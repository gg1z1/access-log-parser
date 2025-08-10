package com.stepup.file;

import java.io.File;
import java.util.Scanner;

public class FileProcessor {

    public static String getValidFilePath() {
        int correctFileCount = 0;
        String filePath;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Введите путь к файлу: ");
            //filePath = scanner.nextLine();
            filePath = "src\\main\\resources\\access.log";
            File file = new File(filePath);

            if (!file.exists()) {
                System.out.println("Ошибка: файл не существует");
                continue;
            }

            if (file.isDirectory()) {
                System.out.println("Ошибка: указан путь к директории, а не к файлу");
                continue;
            }

            correctFileCount++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + correctFileCount);
            break;

        } while (true);
        return filePath;
    }
}
