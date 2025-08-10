package com.stepup.parsers;

import com.stepup.patterns.LogEntry;
import com.stepup.patterns.LogParser;
import com.stepup.useragent.UserAgentParser;

public class BotLogParser extends AbstractLogParser {

    private  LogParser logParser;

    public BotLogParser(String filePath) {
        super(filePath);
        this.logParser = new LogParser();
        this.botStats = new BotStatistics();
    }

    @Override
    protected void processLine(String line) {
        try {
            //Возвращает обёртку разобранной на блоки (паттерны) строки
            LogEntry entry = logParser.parseLogLine(line);

            //Получается информацию об юзер-агенте
            String userAgent = entry.getUserAgent();

            //если строка об юзер-агенте пустая, статистику не собираем
            if (userAgent == null || userAgent.isEmpty()) return;

            //если юзер-агент есть, извлекаем информацию о нём
            String botInfo = UserAgentParser.extractBotInfo(userAgent);

            //если юзер-агент нашел
            botStats.processBot(botInfo);
        } catch (Exception e) {
            System.err.println("Ошибка при обработке строки: " + e.getMessage());
        }
    }

    public BotStatistics getStatistics() {
        return botStats;
    }
}
