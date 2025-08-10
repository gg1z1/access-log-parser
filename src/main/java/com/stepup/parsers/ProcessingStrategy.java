package com.stepup.parsers;

public interface ProcessingStrategy {
    public void processLine(String line);
    public void printStatistics();
}