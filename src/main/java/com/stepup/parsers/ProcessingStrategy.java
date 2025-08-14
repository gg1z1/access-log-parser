package com.stepup.parsers;

import com.stepup.patterns.LogEntry;

import java.util.List;

public interface ProcessingStrategy {
    public void processSingleEntry(LogEntry entry);  // новое
    public void printStatistics();
}