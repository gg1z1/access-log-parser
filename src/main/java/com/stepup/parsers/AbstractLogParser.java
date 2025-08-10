package com.stepup.parsers;

import com.stepup.exeptions.LineLengthException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

abstract class AbstractLogParser {
    protected String filePath;
    protected BotStatistics botStats;

    public AbstractLogParser(String filePath) {
        this.filePath = filePath;
        this.botStats = new BotStatistics();
    }

    public void parse() {
        try ( FileReader fileReader = new FileReader(filePath);
              BufferedReader reader = new BufferedReader(fileReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                if (length > LineLengthException.MAX_LINE_LENGTH) throw new LineLengthException(length);
                processLine(line);
            }
        } catch (LineLengthException e) {
            System.err.println("Ошибка длины строки: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    protected abstract void processLine(String line);

    public BotStatistics getStatistics() {
        return botStats;
    }
}
