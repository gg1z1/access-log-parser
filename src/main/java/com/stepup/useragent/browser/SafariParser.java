package com.stepup.useragent.browser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SafariParser extends AbstractBrowserParser {
    // Базовый паттерн для проверки Safari
    private static final Pattern BASE_SAFARI_PATTERN = Pattern.compile("Version/(\\d+\\.\\d+)");

    // Отдельные паттерны для компонентов
    private static final Pattern OS_PATTERN = Pattern.compile("^\\((?<os>[^)]+)\\)");
    private static final Pattern WEBKIT_PATTERN = Pattern.compile("AppleWebKit/(\\d+\\.\\d+)");
    private static final Pattern SAFARI_VERSION_PATTERN = Pattern.compile("Version/(\\d+\\.\\d+)");
    private static final Pattern SAFARI_BUILD_PATTERN = Pattern.compile("Safari/(\\d+\\.\\d+)");

    public SafariParser() {
        // Используем базовый паттерн для определения Safari
        super(String.valueOf(BASE_SAFARI_PATTERN));
    }

    @Override
    public BrowserInfo parse(String userAgent) {
        //System.out.println("Парсим Safari: " + userAgent);

        // Проверяем базовый паттерн
        Matcher baseMatcher = BASE_SAFARI_PATTERN.matcher(userAgent);
        if (!baseMatcher.find()) {
            System.err.println("Не удалось найти Safari в: " + userAgent);
            return null;
        }
        String safariVersion = baseMatcher.group(1);

        // Парсим ОС
        Matcher osMatcher = OS_PATTERN.matcher(userAgent);
        String os = osMatcher.find() ? osMatcher.group("os") : "Unknown";

        // Парсим WebKit версию
        Matcher webkitMatcher = WEBKIT_PATTERN.matcher(userAgent);
        String webkitVersion = webkitMatcher.find() ? webkitMatcher.group(1) : "Unknown";

        // Парсим сборку Safari
        Matcher safariBuildMatcher = SAFARI_BUILD_PATTERN.matcher(userAgent);
        String safariBuild = safariBuildMatcher.find() ? safariBuildMatcher.group(1) : "Unknown";

//        System.out.println("Определен Safari:");
//        System.out.println("Версия: " + safariVersion);
//        System.out.println("ОС: " + os);
//        System.out.println("WebKit: " + webkitVersion);
//        System.out.println("Сборка: " + safariBuild);

        return new BrowserInfo(
                userAgent, // rawUserAgent
                getPlatform(userAgent), // platform
                os, // os
                getDevice(userAgent), // device
                "Safari", // browserName
                safariVersion, // browserVersion
                "WebKit", // engine
                isMobile(userAgent), // isMobile
                getOsVersion(userAgent), // osVersion
                getArchitecture(userAgent) // architecture
        );
    }
}

