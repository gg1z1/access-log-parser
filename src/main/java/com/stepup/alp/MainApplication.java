package com.stepup.alp;

import com.stepup.file.FileProcessor;
import com.stepup.parsers.BotProcessingStrategy;
import com.stepup.parsers.PageProcessingStrategy;
import com.stepup.parsers.TrafficProcessingStrategy;


public class MainApplication {
    public static void main(String[] args) {

//        FileProcessor processor = new FileProcessor(new BotProcessingStrategy());
//        processor.processFile("src/main/resources/access.log");
//        processor.printStatistics();
//        // Для статистики трафика
//        FileProcessor trafficProcessor = new FileProcessor(new TrafficProcessingStrategy());
//        trafficProcessor.processFile("src/main/resources/access.log");
//        trafficProcessor.printStatistics();
        FileProcessor processor = new FileProcessor();
        processor.addStrategy(new BotProcessingStrategy());
        processor.addStrategy(new TrafficProcessingStrategy());
        processor.addStrategy(new PageProcessingStrategy());

        processor.processFile("src/main/resources/access.log"); // Парсинг происходит один раз
        processor.printStatistics();
    }
}

