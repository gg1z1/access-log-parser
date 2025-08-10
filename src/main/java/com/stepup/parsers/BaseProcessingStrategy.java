package com.stepup.parsers;

import com.stepup.patterns.LogEntry;
import com.stepup.patterns.LogParser;

public abstract class BaseProcessingStrategy implements ProcessingStrategy {
    private final LogParser parser = new LogParser();

    @Override
    public void processLine(String line) {
        try {
            LogEntry entry = parseLine(line);
            if (entry != null) {
                processEntry(entry);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при обработке строки: " + e.getMessage());
        }
    }

    // Метод для парсинга строки в LogEntry
    protected LogEntry parseLine(String line){
        return parser.parseLogLine(line);
    }

    // Метод для обработки LogEntry
    protected abstract void processEntry(LogEntry entry);

    @Override
    public abstract void printStatistics();
}
