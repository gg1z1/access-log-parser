package com.stepup.parsers;

import com.stepup.patterns.LogEntry;

import java.util.List;

public abstract class BaseProcessingStrategy implements ProcessingStrategy {

    protected abstract void processEntry(LogEntry entry);

    @Override
    public void processEntries(List<LogEntry> entries) {
        for (LogEntry entry : entries) {
            processEntry(entry);
        }
    }

    @Override
    public abstract void printStatistics();
}
