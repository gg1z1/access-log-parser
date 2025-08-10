package com.stepup.statistics;

import com.stepup.patterns.LogEntry;

public interface Statistics {
    void addEntry(LogEntry entry);
    void printStatistics();
}