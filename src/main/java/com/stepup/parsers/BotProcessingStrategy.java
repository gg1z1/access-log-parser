package com.stepup.parsers;

import com.stepup.patterns.LogEntry;
import com.stepup.statistics.BotStatistics;

public class BotProcessingStrategy extends BaseProcessingStrategy {
    private final BotStatistics stats = new BotStatistics();

    @Override
    protected void processEntry(LogEntry entry) {
        stats.addEntry(entry);
    }

    @Override
    public void printStatistics() {
        stats.printStatistics();
    }
}
