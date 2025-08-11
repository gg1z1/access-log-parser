package com.stepup.file;

import com.stepup.exeptions.LineLengthException;
import com.stepup.parsers.ProcessingStrategy;
import com.stepup.patterns.LogEntry;
import com.stepup.patterns.LogParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {

    private List<ProcessingStrategy> strategies = new ArrayList<>();
    private List<LogEntry> parsedEntries;

    public FileProcessor() {

    }

    public void addStrategy(ProcessingStrategy strategy) {
        strategies.add(strategy);
    }

    public void processFile(String filePath) {
        parsedEntries = parseFile(filePath);
        for (ProcessingStrategy strategy : strategies) {
            strategy.processEntries(parsedEntries);
        }
    }

    private List<LogEntry> parseFile(String filePath) {
        List<LogEntry> entries = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String line;
            LogParser parser = new LogParser();
            while ((line = reader.readLine()) != null) {
                try {
                    LogEntry logParseResult = parser.parseLogLine(line);
                    entries.add(logParseResult);
                } catch (Exception e) {
                    System.err.println("Ошибка парсинга строки: " + line);
                }
            }
        } catch (LineLengthException e) {
            System.err.println("Ошибка длины строки: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return entries;
    }

    public void printStatistics() {
//        strategy.printStatistics();
        for (ProcessingStrategy strategy : strategies) {
            strategy.printStatistics();
        }
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
