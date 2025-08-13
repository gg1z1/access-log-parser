package com.stepup.useragent.browser;

import java.util.regex.Pattern;

public abstract class AbstractBrowserParser implements BrowserParser {
    protected final Pattern pattern;

    protected AbstractBrowserParser(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean matches(String userAgent) {
        return pattern.matcher(userAgent).find();
    }

    // Определение ОС
    protected String getOs(String userAgent) {
        if (userAgent.contains("Windows")) return "Windows";
        if (userAgent.contains("Macintosh")) return "MacOS";
        if (userAgent.contains("Linux")) return "Linux";
        if (userAgent.contains("Android")) return "Android";
        return "Unknown";
    }

    // Определение платформы
    protected String getPlatform(String userAgent) {
        if (userAgent.contains("Windows NT")) return "Windows";
        if (userAgent.contains("Macintosh")) return "Mac";
        if (userAgent.contains("X11")) return "Linux";
        return "Unknown";
    }

    // Определение мобильного устройства
    protected boolean isMobile(String userAgent) {
        return userAgent.contains("Mobile") ||
                userAgent.contains("Android") ||
                userAgent.contains("iPhone") ||
                userAgent.contains("iPad");
    }

    // Определение архитектуры
    protected String getArchitecture(String userAgent) {
        if (userAgent.contains("x86_64")) return "x64";
        if (userAgent.contains("x86")) return "x86";
        if (userAgent.contains("arm")) return "arm";
        return "Unknown";
    }

    // Определение версии ОС (базовая реализация)
    protected String getOsVersion(String userAgent) {
        // Здесь можно добавить более сложную логику определения версии ОС
        return "Unknown";
    }

    // Определение типа устройства
    protected String getDevice(String userAgent) {
        if (isMobile(userAgent)) {
            if (userAgent.contains("iPad")) return "Tablet";
            return "Mobile";
        }
        return "Desktop";
    }

    // Определение типа User-Agent
    protected String getUserAgentType(String userAgent) {
        if (isMobile(userAgent)) return "Mobile";
        return "Desktop";
    }
}
