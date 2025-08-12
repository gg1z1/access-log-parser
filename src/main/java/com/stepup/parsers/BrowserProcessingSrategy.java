package com.stepup.parsers;

import com.stepup.patterns.LogEntry;
import com.stepup.statistics.BrowserStatistics;
import com.stepup.statistics.PageStatistics;

public class BrowserProcessingSrategy extends BaseProcessingStrategy{
    private final BrowserStatistics stats = new BrowserStatistics();

    @Override
    protected void processEntry(LogEntry entry) {
        stats.addEntry(entry);
    }

    @Override
    public void printStatistics() {
        stats.printStatistics();
    }
}
