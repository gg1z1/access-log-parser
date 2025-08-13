package com.stepup.useragent.browser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirefoxParser extends AbstractBrowserParser {
    // Базовый паттерн для проверки Firefox
    private static final Pattern BASE_FIREFOX_PATTERN = Pattern.compile("Firefox/(\\d+\\.\\d+)");

    // Отдельные паттерны для компонентов
    private static final Pattern OS_PATTERN = Pattern.compile("^\\((?<os>[^\\)]+)\\)");
    private static final Pattern GECKO_PATTERN = Pattern.compile("Gecko/(\\d+)");
    private static final Pattern FIREFOX_VERSION_PATTERN = Pattern.compile("Firefox/(\\d+\\.\\d+)");

    public FirefoxParser() {
        // Используем базовый паттерн для определения Firefox
        super(String.valueOf(BASE_FIREFOX_PATTERN));
    }

    @Override
    public BrowserInfo parse(String userAgent) {
        //System.out.println("Парсим Firefox: " + userAgent);

        // Проверяем базовый паттерн
        Matcher baseMatcher = BASE_FIREFOX_PATTERN.matcher(userAgent);
        if (!baseMatcher.find()) {
            System.err.println("Не удалось найти Firefox в: " + userAgent);
            return null;
        }
        String firefoxVersion = baseMatcher.group(1);

        // Парсим ОС
        Matcher osMatcher = OS_PATTERN.matcher(userAgent);
        String os = osMatcher.find() ? osMatcher.group("os") : "Unknown";

        // Парсим версию Gecko
        Matcher geckoMatcher = GECKO_PATTERN.matcher(userAgent);
        String geckoVersion = geckoMatcher.find() ? geckoMatcher.group(1) : "Unknown";

//        System.out.println("Определен Firefox:");
//        System.out.println("Версия: " + firefoxVersion);
//        System.out.println("ОС: " + os);
//        System.out.println("Gecko: " + geckoVersion);

        return new BrowserInfo(
                userAgent, // rawUserAgent
                getPlatform(userAgent), // platform
                os, // os
                getDevice(userAgent), // device
                "Firefox", // browserName
                firefoxVersion, // browserVersion
                "Gecko", // engine
                isMobile(userAgent), // isMobile
                getOsVersion(userAgent), // osVersion
                getArchitecture(userAgent) // architecture
        );
    }
}