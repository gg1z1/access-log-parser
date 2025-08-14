package com.stepup.statistics;

import com.stepup.exeptions.LineLengthException;
import com.stepup.patterns.LogEntry;
import com.stepup.useragent.base.UserAgentInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BrowserStatistics implements Statistics {
    // Для хранения несуществующих страниц (404)
    private final HashSet<String> notFoundPages = new HashSet<>();

    // Для подсчета браузеров
    private final Map<String, Integer> browserCount = new HashMap<>();
    private int totalBrowsers = 0;

    @Override
    public void addEntry(LogEntry entry) {
        // Обработка 404 страниц
        if (entry.getResponseCode() == 404) notFoundPages.add(entry.getRequestPath());

        String browser = "";
        UserAgentInfo userAgentInfo = entry.getUserAgent();
// Подсчет браузеров
        try {
            if (userAgentInfo.hasBrowser() && !userAgentInfo.hasBot()) {
                browser = userAgentInfo.getBrowserInfo().getBrowserName();
            }
//            else if (userAgentInfo.hasBot()) {
//                browser = "Bot: " + userAgentInfo.getBotInfo().getBotName();
//            }
        } catch (NullPointerException e) {
            System.err.println("Ошибка при обработке User-Agent: " +
                    "Не удалось определить браузер для User-Agent: " + entry.getUserAgent() +
                    "\nСтрока в логе: " + entry.getLineNumber() +
                    "\nПричина ошибки: " + e.getMessage());
        }

        browserCount.put(browser, browserCount.getOrDefault(browser, 0) + 1);
        totalBrowsers++;
    }

    public HashSet<String> getNotFoundPages() {
        return new HashSet<>(notFoundPages); // Возвращаем копию для безопасности
    }

    // Метод для получения статистики браузеров в виде долей
    public Map<String, Double> getBrowserShares() {
        Map<String, Double> browserShares = new HashMap<>();

        // Проверяем на деление на ноль
        if (totalBrowsers == 0) {
            return browserShares;
        }

        // Рассчитываем долю для каждого браузера
        for (Map.Entry<String, Integer> entry : browserCount.entrySet()) {
            double share = (double) entry.getValue() / totalBrowsers;
            browserShares.put(entry.getKey(), share);
        }

        return browserShares;
    }

    @Override
    public void printStatistics() {
        Map<String, Double> browserShares = getBrowserShares();

        System.out.println("Статистика браузеров:");
        for (Map.Entry<String, Double> entry : browserShares.entrySet()) {
            System.out.printf("%-15s: %6.2f%%%n",
                    entry.getKey(), entry.getValue() * 100);
        }
    }
}
