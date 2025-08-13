package com.stepup.useragent.browser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IEParser extends AbstractBrowserParser {
    // Базовый паттерн для проверки IE (теперь учитывает оба варианта)
    private static final Pattern BASE_IE_PATTERN = Pattern.compile("(?:Mozilla/4\\.0|Mozilla/5\\.0).*MSIE (\\d+\\.\\d+)");

    // Новые паттерны для дополнительных параметров IE10
    private static final Pattern TRIDENT_PATTERN = Pattern.compile("Trident/(\\d+\\.\\d+)");
    private static final Pattern ARCH_PATTERN = Pattern.compile("(Win64; x64)");

    // Существующие паттерны
    private static final Pattern OS_PATTERN = Pattern.compile("Windows NT (\\d+\\.\\d+)");
    private static final Pattern CLR_PATTERN = Pattern.compile("\\.NET CLR (\\d+\\.\\d+\\.\\d+)");
    private static final Pattern INFO_PATTERN = Pattern.compile("InfoPath\\.(\\d+)");
    private static final Pattern AOL_PATTERN = Pattern.compile("AOL (\\d+\\.\\d+)");

    public IEParser() {
        super(String.valueOf(BASE_IE_PATTERN));
    }

    @Override
    public BrowserInfo parse(String userAgent) {
        // Проверяем базовый паттерн
        Matcher baseMatcher = BASE_IE_PATTERN.matcher(userAgent);
        if (!baseMatcher.find()) {
            System.err.println("Не удалось найти IE в: " + userAgent);
            return null;
        }
        String ieVersion = baseMatcher.group(1);

        // Парсим новые параметры
        Matcher tridentMatcher = TRIDENT_PATTERN.matcher(userAgent);
        String tridentVersion = tridentMatcher.find() ? tridentMatcher.group(1) : "Unknown";

        Matcher archMatcher = ARCH_PATTERN.matcher(userAgent);
        String architecture = archMatcher.find() ? archMatcher.group(1) : "Unknown";

        // Парсим существующие параметры
        Matcher osMatcher = OS_PATTERN.matcher(userAgent);
        String osVersion = osMatcher.find() ? osMatcher.group(1) : "Unknown";

        Matcher clrMatcher = CLR_PATTERN.matcher(userAgent);
        String clrVersion = clrMatcher.find() ? clrMatcher.group(1) : "Unknown";

        Matcher infoMatcher = INFO_PATTERN.matcher(userAgent);
        String infoVersion = infoMatcher.find() ? infoMatcher.group(1) : "Unknown";

        Matcher aolMatcher = AOL_PATTERN.matcher(userAgent);
        String aolVersion = aolMatcher.find() ? aolMatcher.group(1) : "Unknown";

//        System.out.println("Определен IE:");
//        System.out.println("Версия: " + ieVersion);
//        System.out.println("ОС: Windows NT " + osVersion);
//        System.out.println("Trident: " + tridentVersion);
//        System.out.println("Архитектура: " + architecture);
//        System.out.println(".NET CLR: " + clrVersion);
//        System.out.println("InfoPath: " + infoVersion);
//        System.out.println("AOL: " + aolVersion);

        return new BrowserInfo(
                userAgent, // rawUserAgent
                getPlatform(userAgent), // platform
                "Windows NT " + osVersion, // os
                getDevice(userAgent), // device
                "Internet Explorer", // browserName
                ieVersion, // browserVersion
                "Trident/" + tridentVersion, // engine
                false, // isMobile
                osVersion, // osVersion
                architecture // architecture
        );
    }
}
