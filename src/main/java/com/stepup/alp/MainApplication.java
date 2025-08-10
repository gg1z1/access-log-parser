package com.stepup.alp;

import com.stepup.file.FileProcessor;
import com.stepup.parsers.BotProcessingStrategy;
import com.stepup.parsers.TrafficProcessingStrategy;


public class MainApplication {
    public static void main(String[] args) {

//        FileProcessor fileProcessor = new FileProcessor();
//        String filePath = fileProcessor.getValidFilePath();
//        BotProcessingStrategy parser = new BotProcessingStrategy(filePath);
//        parser.parse();
//        parser.getStatistics().printStatistics();
//        System.out.println("\nПарсинг завершен успешно!");

        FileProcessor processor = new FileProcessor(new BotProcessingStrategy());
        processor.processFile("src/main/resources/access.log");
        processor.printStatistics();

        // Для статистики трафика
        FileProcessor trafficProcessor = new FileProcessor(new TrafficProcessingStrategy());
        trafficProcessor.processFile("src/main/resources/access.log");
        trafficProcessor.printStatistics();
    }
}

