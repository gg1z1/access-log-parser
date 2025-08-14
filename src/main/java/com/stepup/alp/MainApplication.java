package com.stepup.alp;

import com.stepup.file.FileProcessor;
import com.stepup.parsers.*;


public class MainApplication {
    public static void main(String[] args) {

        FileProcessor processor = new FileProcessor();
        processor.addStrategy(new BotProcessingStrategy());
        processor.addStrategy(new TrafficProcessingStrategy());
        processor.addStrategy(new PageProcessingStrategy());
        processor.addStrategy(new BrowserProcessingSrategy());
        processor.addStrategy(new HourlyTrafficStrategy());
        processor.processFile("src/main/resources/access.log");
        //processor.processFile("src/main/resources/access_2.log"); // Парсинг происходит один раз
        processor.printStatistics();
    }
}

