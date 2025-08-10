package com.stepup.alp;

import com.stepup.exeptions.LineLengthException;
import com.stepup.file.FileProcessor;
import com.stepup.parsers.BotLogParser;

import java.io.*;
import java.util.Scanner;


public class MainApplication {
    public static void main(String[] args) {

        FileProcessor fileProcessor = new FileProcessor();
        String filePath = fileProcessor.getValidFilePath();
        BotLogParser parser = new BotLogParser(filePath);
        parser.parse();
        parser.getStatistics().printStatistics();
        System.out.println("\nПарсинг завершен успешно!");
    }
}

