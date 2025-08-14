package com.stepup.file;

import com.stepup.exeptions.LineLengthException;
import com.stepup.parsers.ProcessingStrategy;
import com.stepup.patterns.LogEntry;
import com.stepup.patterns.LogParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessor {

    private List<ProcessingStrategy> strategies = new ArrayList<>();
    private List<LogEntry> parsedEntries;
    private AtomicInteger totalLines = new AtomicInteger(0); // Общий счетчик строк

    public FileProcessor() {

    }

    public void addStrategy(ProcessingStrategy strategy) {
        strategies.add(strategy);
    }


    public void processFile(String filePath) {
        long startTime = System.nanoTime();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.parallel()
                    .map(this::parseLine)
                    .filter(Objects::nonNull)
                    .forEach(entry -> {
                        strategies.forEach(strategy -> {
                            try {
                                strategy.processSingleEntry(entry);
                            } catch (Exception e) {
                                System.err.println("Ошибка обработки записи в стратегии " +
                                        strategy.getClass().getSimpleName() + ": " + e.getMessage());
                            }
                        });
                    });
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }finally {
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Время выполнения: " + duration + " наносекунд");
            System.out.println("Количество обработанных строк: " + totalLines);
        }
    }

    private LogEntry parseLine(String line) {
        try {
            totalLines.incrementAndGet(); // Увеличиваем счетчик
            if (line.length() > LineLengthException.MAX_LINE_LENGTH)
                throw new LineLengthException(totalLines.get(), line.length());
            return new LogParser().parseLogLine(totalLines.get() + ": " + line);

        } catch (LineLengthException e) {
            System.err.println("Ошибка допустимой длины строки: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Ошибка обработки строки " + totalLines.get() + ": " + line);
            return null;
        }
    }

    public void printStatistics() {
        for (ProcessingStrategy strategy : strategies) {
            strategy.printStatistics();
        }
    }

    //пока отключил, что бы тестировать
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
