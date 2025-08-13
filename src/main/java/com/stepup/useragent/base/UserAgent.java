package com.stepup.useragent.base;

import com.stepup.useragent.bot.BotInfo;
import com.stepup.useragent.bot.BotParser;
import com.stepup.useragent.browser.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgent {
    private final List<BrowserParser> browserParsers;
    private final BotParser botParser;

    public UserAgent() {
        browserParsers = new ArrayList<>();
        browserParsers.add(new EdgeParser());
        browserParsers.add(new OperaParser());
        browserParsers.add(new FirefoxParser());
        browserParsers.add(new SafariParser());
        browserParsers.add(new ChromeParser());
        browserParsers.add(new IEParser());

        botParser = new BotParser();
    }

    public UserAgentInfo parse(String userAgent) {
        if (userAgent == null || userAgent.isEmpty()) {
            return new UserAgentInfo(createUnknownBrowserInfo(), null);
        }

        // Сначала разделяем строку на базовую часть и бота
        String[] parts = splitUserAgent(userAgent);
        String baseUserAgent = parts[0];
        String botPart = parts[1];

        // Парсим браузер
        BrowserInfo browserInfo = checkForBrowser(baseUserAgent);

//        // Парсим бота, если есть часть с ботом
//        BotInfo botInfo = botPart != null && !botPart.isEmpty()
//                ? botParser.parse(botPart)
//                : null;

        BotInfo botInfo;

// Проверяем, есть ли часть с ботом
        if (botPart != null && !botPart.trim().isEmpty()) {
            //System.out.println("Найденная часть бота: " + botPart);

            try {
                botInfo = botParser.parse(botPart);

                if (botInfo == null) {
                    //System.err.println("Парсер не смог определить бота для: " + botPart);
                }
            } catch (Exception e) {
                System.err.println("Ошибка при парсинге бота: " + e.getMessage());
                botInfo = null;
            }
        } else {
            //System.out.println("Часть бота пуста или null");
            botInfo = null;
        }

        return new UserAgentInfo(browserInfo, botInfo);
    }

    private String[] splitUserAgent(String userAgent) {

        // Проверяем версию Mozilla/5.0
        if (!userAgent.contains("MSIE")) {
            // Используем основной паттерн для проверки бота
            Matcher matcher = BOT_SEPARATOR_PATTERN.matcher(userAgent);
            if (matcher.find()) {
                return new String[] {
                        matcher.group(1), // базовая часть
                        matcher.group(2)  // часть с ботом
                };
            }
            // Если не найдено, возвращаем как обычный браузер
            return new String[] {userAgent, ""};
        }
        // Проверяем версию Mozilla/4.0
        return new String[] {userAgent, ""};
    }

    private static final Pattern BOT_SEPARATOR_PATTERN = Pattern.compile(
            "(?i)^(.+?)\\s*\\(\\s*compatible; (.+?)\\)"
    );

    private BrowserInfo checkForBrowser(String userAgent) {
        for (BrowserParser parser : browserParsers) {
            if (parser.matches(userAgent)) {
                return parser.parse(userAgent);
            }
        }
        return null;
    }

    private BrowserInfo createUnknownBrowserInfo() {
        return new BrowserInfo(
                "Unknown",     // rawUserAgent
                "Unknown",     // platform
                "Unknown",     // os
                "Unknown",     // device
                "Unknown",     // browserName
                "Unknown",     // browserVersion
                "Unknown",     // engine
                false,         // isMobile
                "Unknown",     // osVersion
                "Unknown"      // architecture
        );
    }
}