package com.stepup.parsers;

import com.stepup.patterns.LogEntry;
import com.stepup.statistics.PageStatistics;

public class PageProcessingStrategy extends BaseProcessingStrategy{
    private final PageStatistics stats = new PageStatistics();

    @Override
    protected void processEntry(LogEntry entry) {
        stats.addEntry(entry);
    }

    @Override
    public void printStatistics() {
        stats.printStatistics();
    }
}
