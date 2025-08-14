package com.stepup.parsers;

import com.stepup.patterns.LogEntry;
import com.stepup.statistics.HourlyTrafficStatistics;

public class HourlyTrafficStrategy extends BaseProcessingStrategy{

    private final HourlyTrafficStatistics stats = new HourlyTrafficStatistics();

    @Override
    protected void processEntry(LogEntry entry) {
        stats.addEntry(entry);
    }

    @Override
    public void printStatistics() {
        stats.printStatistics();
    }
}