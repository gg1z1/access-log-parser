package com.stepup.useragent.browser;

public class BrowserInfo {
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

    public BrowserInfo(
            String rawUserAgent,
            String platform,
            String os,
            String device,
            String browserName,
            String browserVersion,
            String engine,
            boolean isMobile,
            String osVersion,
            String architecture
    ) {
        this.rawUserAgent = rawUserAgent;
        this.platform = platform;
        this.os = os;
        this.device = device;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.engine = engine;
        this.isMobile = isMobile;
        this.osVersion = osVersion;
        this.architecture = architecture;
    }

    // Геттеры
    public String getRawUserAgent() { return rawUserAgent; }
    public String getPlatform() { return platform; }
    public String getOs() { return os; }
    public String getDevice() { return device; }
    public String getBrowserName() { return browserName; }
    public String getBrowserVersion() { return browserVersion; }
    public String getEngine() { return engine; }
    public boolean isMobile() { return isMobile; }
    public String getOsVersion() { return osVersion; }
    public String getArchitecture() { return architecture; }

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
                  Мобильный: %b
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
                isMobile(),
                getRawUserAgent()
        );
    }
}
