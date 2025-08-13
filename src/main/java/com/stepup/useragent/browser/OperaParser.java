package com.stepup.useragent.browser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperaParser extends AbstractBrowserParser {
    // Базовый паттерн для проверки Opera
    private static final Pattern BASE_OPERA_PATTERN = Pattern.compile("OPR/(\\d+\\.\\d+\\.\\d+\\.\\d+)");

    // Отдельные паттерны для компонентов
    private static final Pattern OS_PATTERN = Pattern.compile("^\\((?<os>[^\\)]+)\\)");
    private static final Pattern WEBKIT_PATTERN = Pattern.compile("AppleWebKit/(\\d+\\.\\d+)");
    private static final Pattern CHROME_PATTERN = Pattern.compile("Chrome/(\\d+\\.\\d+\\.\\d+\\.\\d+)");
    private static final Pattern SAFARI_PATTERN = Pattern.compile("Safari/(\\d+\\.\\d+)");
    private static final Pattern OPERA_VERSION_PATTERN = Pattern.compile("OPR/(\\d+\\.\\d+\\.\\d+\\.\\d+)");

    public OperaParser() {
        // Используем базовый паттерн для определения Opera
        super(String.valueOf(BASE_OPERA_PATTERN));
    }

    @Override
    public BrowserInfo parse(String userAgent) {
        //System.out.println("Парсим Opera: " + userAgent);

        // Проверяем базовый паттерн
        Matcher baseMatcher = BASE_OPERA_PATTERN.matcher(userAgent);
        if (!baseMatcher.find()) {
            System.err.println("Не удалось найти Opera в: " + userAgent);
            return null;
        }
        String operaVersion = baseMatcher.group(1);

        // Парсим ОС
        Matcher osMatcher = OS_PATTERN.matcher(userAgent);
        String os = osMatcher.find() ? osMatcher.group("os") : "Unknown";

        // Парсим WebKit версию
        Matcher webkitMatcher = WEBKIT_PATTERN.matcher(userAgent);
        String webkitVersion = webkitMatcher.find() ? webkitMatcher.group(1) : "Unknown";

        // Парсим Chrome версию
        Matcher chromeMatcher = CHROME_PATTERN.matcher(userAgent);
        String chromeVersion = chromeMatcher.find() ? chromeMatcher.group(1) : "Unknown";

        // Парсим Safari версию
        Matcher safariMatcher = SAFARI_PATTERN.matcher(userAgent);
        String safariVersion = safariMatcher.find() ? safariMatcher.group(1) : "Unknown";

//        System.out.println("Определена Opera:");
//        System.out.println("Версия: " + operaVersion);
//        System.out.println("ОС: " + os);
//        System.out.println("WebKit: " + webkitVersion);
//        System.out.println("Chrome: " + chromeVersion);
//        System.out.println("Safari: " + safariVersion);

        return new BrowserInfo(
                userAgent,                  // rawUserAgent
                getPlatform(userAgent),     // platform
                os,                         // os
                getDevice(userAgent),       // device
                "Opera",                   // browserName
                operaVersion,              // browserVersion
                "Blink",                   // engine
                isMobile(userAgent),       // isMobile
                getOsVersion(userAgent),   // osVersion
                getArchitecture(userAgent) // architecture
        );
    }
}