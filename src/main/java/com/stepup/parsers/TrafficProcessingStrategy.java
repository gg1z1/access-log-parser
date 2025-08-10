package com.stepup.parsers;

import com.stepup.patterns.LogEntry;
import com.stepup.statistics.TrafficStatistics;

public class TrafficProcessingStrategy extends BaseProcessingStrategy {
    private final TrafficStatistics stats = new TrafficStatistics();

    @Override
    protected void processEntry(LogEntry entry) {
        stats.addEntry(entry);
    }

    @Override
    public void printStatistics() {
        stats.printStatistics();
    }
}
