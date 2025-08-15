package com.stepup.parsers;

import com.stepup.patterns.LogEntry;
import com.stepup.statistics.VisitStatistics;

public class VisitProcessingStrategy extends BaseProcessingStrategy {
    private final VisitStatistics stats = new VisitStatistics();

    @Override
    protected void processEntry(LogEntry entry) {
        stats.addEntry(entry);
    }

    @Override
    public void printStatistics() {
        stats.printStatistics();
    }
}
