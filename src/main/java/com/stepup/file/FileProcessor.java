package com.stepup.file;

import com.stepup.exeptions.LineLengthException;
import com.stepup.parsers.ProcessingStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileProcessor {

    private final ProcessingStrategy strategy;

    public FileProcessor(ProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    public void processFile(String filePath) {
        try ( FileReader fileReader = new FileReader(filePath);
              BufferedReader reader = new BufferedReader(fileReader)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    // Проверяем длину строки
                    if (line.length() > LineLengthException.MAX_LINE_LENGTH) throw new LineLengthException(line.length());
                    // Обрабатываем строку через стратегию
                    strategy.processLine(line);
                }

            } catch (LineLengthException e) {
                System.err.println("Ошибка длины строки: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
    }

    public void printStatistics() {
        strategy.printStatistics();
    }

    public String getValidFilePath() {
        String filePath;
        do {
            System.out.print("Введите путь к файлу лога: ");
            filePath = new Scanner(System.in).nextLine();

            if (!Files.exists(Paths.get(filePath))) {
                System.out.println("Файл не найден! Попробуйте еще раз.");
            }
        } while (!Files.exists(Paths.get(filePath)));

        return filePath;
    }
}
