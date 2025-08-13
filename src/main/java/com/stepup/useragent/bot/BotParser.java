package com.stepup.useragent.bot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotParser {
    public BotInfo parse(String botPart) {
        // Удаляем лишние пробелы и скобки
        String cleanedPart = botPart.trim().replace("(", "").replace(")", "");

        // Разделяем по символу ";"
        String[] parts = cleanedPart.split(";");

        // Очищаем каждую часть от пробелов
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        String botName = "Unknown";
        String botVersion = "Unknown";
        String botUrl = "Unknown";
        String description = "";

        if (parts[0].contains("/")) {
            // Пытаемся найти версию бота
            String[] nameVersion = parts[0].split("/");
            if (nameVersion.length == 2) {
                botName = nameVersion[0];
                botVersion = nameVersion[1];
            }
        } else {
            botName = parts[0] ;
        }

        if (parts[0].contains("+")) {
            String[] nameURL = parts[0].split(" ");
            if (nameURL.length == 2) {
                botName = nameURL[0];
                botUrl = nameURL[1].substring(1).trim();
            }
        }
        for (int i = 1; i < parts.length; i++) {
            if (parts[i].startsWith("+")) botUrl = parts[i].substring(1).trim();
            else description += parts[i] + "; ";
        }

        // Получаем базовую часть User-Agent
        String baseUserAgent = getBaseUserAgent(botPart);

        return new BotInfo(
                baseUserAgent,
                botName,
                botVersion,
                botUrl,
                description
        );
    }

    private String getBaseUserAgent(String botPart) {
        // Возвращаем базовую часть до скобок
        return botPart.split("\\(")[0].trim();
    }
}
//
//public class BotParser {
//    // Паттерн для имени бота (более гибкий)
//    private static final Pattern BOT_NAME_PATTERN = Pattern.compile("^(?<botName>[\\w\\.\\-]+)(?:/|\\s)");
//
//    // Паттерн для версии бота (допускает разные форматы версий)
//    private static final Pattern VERSION_PATTERN = Pattern.compile("(?<botVersion>\\d+(\\.\\d+)*~?\\w*|\\d+)");
//
//    // Паттерн для URL бота (более гибкий)
//    private static final Pattern URL_PATTERN = Pattern.compile("(?:\\s*;\\s*|\\s+)(?:\\+?)(?<botUrl>https?://[^ ]+)");
//
//    public BotInfo parse(String botPart) {
//        //System.out.println("Парсим бота: " + botPart);
//
//        // Парсим имя бота
//        Matcher nameMatcher = BOT_NAME_PATTERN.matcher(botPart);
//        if (!nameMatcher.find()) {
//            System.err.println("Не удалось найти имя бота в: " + botPart);
//            return null;
//        }
//        String botName = nameMatcher.group("botName");
//
//        // Получаем оставшуюся часть строки после имени
//        String remaining = botPart.substring(nameMatcher.end()).trim();
//
//        // Парсим версию
//        Matcher versionMatcher = VERSION_PATTERN.matcher(remaining);
//        if (!versionMatcher.find()) {
//            System.err.println("Не удалось найти версию бота в: " + remaining);
//            return null;
//        }
//        String botVersion = versionMatcher.group("botVersion");
//
//        // Обновляем оставшуюся часть
//        remaining = remaining.substring(versionMatcher.end()).trim();
//
//        // Парсим URL
//        Matcher urlMatcher = URL_PATTERN.matcher(remaining);
//        if (!urlMatcher.find()) {
//            System.err.println("Не удалось найти URL бота в: " + remaining);
//            return null;
//        }
//        String botUrl = urlMatcher.group("botUrl");
//
////        System.out.println("Определен бот: " + botName);
////        System.out.println("Версия: " + botVersion);
////        System.out.println("URL: " + botUrl);
//
//
//        // Получаем базовую часть User-Agent
//        String baseUserAgent = getBaseUserAgent(botPart);
//
//        return new BotInfo(
//                baseUserAgent,
//                botName,
//                botVersion,
//                botUrl
//        );
//    }
//
//
//    private String getBaseUserAgent(String botPart) {
//        // Здесь можно добавить дополнительную логику для получения базовой части
//        // Например, если нужно извлечь что-то конкретное
//        return botPart.split("\\(")[0].trim();
//    }
//
//}
