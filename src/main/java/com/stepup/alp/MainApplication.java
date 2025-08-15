package com.stepup.alp;

import com.stepup.file.FileProcessor;
import com.stepup.parsers.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class MainApplication {

    private static final String DEFAULT_FILE_PATH = "src/main/resources/access.log";
    //private static final String DEFAULT_FILE_PATH = "src/main/resources/access_2.log";

    public static void main(String[] args) {

        FileProcessor processor = new FileProcessor();
//        processor.addStrategy(new BotProcessingStrategy());
//        processor.addStrategy(new TrafficProcessingStrategy());
//        processor.addStrategy(new PageProcessingStrategy());
//        processor.addStrategy(new BrowserProcessingSrategy());
        processor.addStrategy(new HourlyTrafficStrategy());
        processor.addStrategy(new VisitProcessingStrategy());
        processor.processFile(getValidFilePath());
        processor.printStatistics();
    }

    private static String getValidFilePath() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Использовать путь по умолчанию (" + DEFAULT_FILE_PATH + ")? (Y/N)");
        String userInput = scanner.nextLine().trim().toUpperCase();
        if ("Y".equals(userInput)) if (Files.exists(Paths.get(DEFAULT_FILE_PATH))) return DEFAULT_FILE_PATH;
        System.out.println("Файл по умолчанию не найден! Будет запрошен другой путь.");
        return getFilePathWithValidation(scanner);
    }

    private static String getFilePathWithValidation(Scanner scanner) {
        String filePath;
        do {
            System.out.print("Введите путь к файлу лога: ");
            filePath = scanner.nextLine().trim();
            if (!Files.exists(Paths.get(filePath)))
                System.out.println("Файл не найден! Попробуйте еще раз.");
        } while (!Files.exists(Paths.get(filePath)));
        System.out.println("Файл найден!");
        return filePath;
    }
}

