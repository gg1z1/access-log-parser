package com.stepup.useragent;

public class UserAgent {
    private final String rawUserAgent;
    private final String platform;
    private final String os;
    private final String device;
    private final String browserName;
    private final String browserVersion;
    private final String engine;
    private final boolean isMobile;
    private final String osVersion;
    private final String architecture;
    private final boolean isBot;
    private final String userAgentType;

    public UserAgent(String userAgent) {
        this.rawUserAgent = userAgent;
        this.isBot = isBot(userAgent);
        this.userAgentType = determineUserAgentType(userAgent);

        // Базовый парсинг
        String parsedInfo = parseUserAgentString(userAgent);
        String[] parts = parsedInfo.split(";");

        // Инициализация полей
        this.platform = extractPlatform(userAgent);
        this.os = detectOs(userAgent);
        this.device = extractDevice(parts);
        this.browserName = extractBrowserName(parsedInfo);
        this.browserVersion = extractBrowserVersion(parsedInfo);
        this.engine = extractEngine(userAgent);
        this.isMobile = isMobileDevice(userAgent);
        this.osVersion = extractOsVersion(userAgent);
        this.architecture = extractArchitecture(userAgent);
    }

    // Основной метод парсинга
    private String parseUserAgentString(String userAgent) {
        if (userAgent == null || userAgent.isEmpty()) return "";

        int start = userAgent.indexOf('(');
        int end = userAgent.indexOf(')', start);

        if (start == -1 || end == -1) return "";

        String firstBrackets = userAgent.substring(start + 1, end);
        return firstBrackets.trim();
    }

    // Определение типа агента
    private String determineUserAgentType(String userAgent) {
        if (isBot(userAgent)) return "Bot";
        if (isMobileDevice(userAgent)) return "Mobile";
        return "Browser";
    }

    // Определение бота
    private boolean isBot(String userAgent) {
        return userAgent.contains("Bot") ||
                userAgent.contains("Crawler") ||
                userAgent.contains("Spider") ||
                userAgent.contains("compatible");
    }

    // Определение ОС
    private String detectOs(String userAgent) {
        if (userAgent.contains("Windows")) return "Windows";
        if (userAgent.contains("Macintosh") || userAgent.contains("Mac OS X")) return "macOS";
        if (userAgent.contains("Linux")) return "Linux";
        return "Unknown";
    }

    // Извлечение названия браузера
    private String extractBrowserName(String parsedInfo) {
        String[] parts = parsedInfo.split(" ");
        for (String part : parts) {
            if (part.contains("/")) {
                String[] split = part.split("/");
                return split[0].trim();
            }
        }
        return "Unknown";
    }

    // Извлечение версии браузера
    private String extractBrowserVersion(String parsedInfo) {
        String[] parts = parsedInfo.split(" ");
        for (String part : parts) {
            if (part.contains("/")) {
                String[] split = part.split("/");
                if (split.length > 1) {
                    return split[1].trim();
                }
            }
        }
        return "Unknown";
    }

    // Извлечение платформы
    private String extractPlatform(String userAgent) {
        int start = userAgent.indexOf('(');
        if (start == -1) return "Unknown";
        String[] platformParts = userAgent.substring(start + 1).split(";");
        return platformParts[0].trim();
    }

    // Извлечение устройства
    private String extractDevice(String[] parts) {
        for (String part : parts) {
            if (part.contains("Build") || part.contains("Model")) {
                return part.trim();
            }
        }
        return "Unknown";
    }

    // Извлечение движка
    // Извлечение движка
    private String extractEngine(String userAgent) {
        if (userAgent.contains("Gecko")) {
            return "Gecko";
        } else if (userAgent.contains("AppleWebKit")) {
            return "WebKit";
        } else if (userAgent.contains("Blink")) {
            return "Blink";
        } else if (userAgent.contains("Trident")) {
            return "Trident";
        }
        return "Unknown";
    }

    // Определение мобильного устройства
    private boolean isMobileDevice(String userAgent) {
        String[] mobileKeywords = {"Mobi", "Android", "iPhone", "iPad", "iPod", "BlackBerry", "Windows Phone"};
        for (String keyword : mobileKeywords) {
            if (userAgent.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    // Извлечение версии ОС
    private String extractOsVersion(String userAgent) {
        if (userAgent.contains("Windows NT")) {
            String[] parts = userAgent.split("Windows NT ");
            if (parts.length > 1) {
                return parts[1].split(" ")[0];
            }
        } else if (userAgent.contains("Android")) {
            String[] parts = userAgent.split("Android ");
            if (parts.length > 1) {
                return parts[1].split(" ")[0];
            }
        }
        return "Unknown";
    }

    // Извлечение архитектуры
    private String extractArchitecture(String userAgent) {
        if (userAgent.contains("x86_64")) {
            return "x86_64";
        } else if (userAgent.contains("arm")) {
            return "ARM";
        } else if (userAgent.contains("x86")) {
            return "x86";
        }
        return "Unknown";
    }

    // Геттеры для всех полей
    public String getRawUserAgent() {
        return rawUserAgent;
    }

    public String getPlatform() {
        return platform;
    }

    public String getOs() {
        return os;
    }

    public String getDevice() {
        return device;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public String getEngine() {
        return engine;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String getArchitecture() {
        return architecture;
    }

    public boolean isBot() {
        return isBot;
    }

    public String getUserAgentType() {
        return userAgentType;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        UserAgent:
                          Браузер: %s
                          Версия браузера: %s
                          Движок: %s
                          Платформа: %s
                          Операционная система: %s
                          Версия ОС: %s
                          Устройство: %s
                          Архитектура: %s
                          Тип агента: %s
                          Мобильный: %b
                          Бот: %b
                          Исходная строка: %s
                        """,

                getBrowserName(),
                getBrowserVersion(),
                getEngine(),
                getPlatform(),
                getOs(),
                getOsVersion(),
                getDevice(),
                getArchitecture(),
                getUserAgentType(),
                isMobile(),
                isBot(),
                getRawUserAgent()
        );
    }
}