package com.stepup.parsers;

import com.stepup.patterns.LogEntry;

import java.util.List;

public interface ProcessingStrategy {
    public void processEntries(List<LogEntry> entries);
    public void printStatistics();
}