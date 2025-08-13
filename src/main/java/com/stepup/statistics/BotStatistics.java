package com.stepup.statistics;

import com.stepup.patterns.LogEntry;
import com.stepup.useragent.base.UserAgentInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BotStatistics implements Statistics {
    private static final String GOOGLEBOT = "Googlebot";
    private static final String YANDEXBOT = "YandexBot";

    private final Map<String, AtomicInteger> botCounts = new HashMap<>();
    private final AtomicInteger totalLines = new AtomicInteger(0);

    public BotStatistics() {
        botCounts.put(GOOGLEBOT, new AtomicInteger(0));
        botCounts.put(YANDEXBOT, new AtomicInteger(0));
        botCounts.put("Unknown", new AtomicInteger(0));
    }

    @Override
    public void addEntry(LogEntry entry) {
        UserAgentInfo userAgent = entry.getUserAgent();
        if (userAgent == null) return;

        totalLines.incrementAndGet();
        String botName = userAgent.getBrowserInfo().getBrowserName();

        if (botCounts.containsKey(botName)) {
            botCounts.get(botName).incrementAndGet();
        } else {
            botCounts.get("Unknown").incrementAndGet();
        }
    }

    @Override
    public void printStatistics() {
        if (totalLines.get() == 0) {
            System.out.println("Файл пуст");
            return;
        }

        System.out.println("Статистика запросов ботов:");
        System.out.println("-------------------------");

        for (Map.Entry<String, AtomicInteger> entry : botCounts.entrySet()) {
            String botName = entry.getKey();
            int count = entry.getValue().get();
            if (count > 0) {
                double percentage = (double) count / totalLines.get() * 100;
                System.out.printf("%-15s: %d (%6.2f%%)%n", botName, count, percentage);
            }
        }

        System.out.println("-------------------------");
        System.out.println("Общее количество строк: " + totalLines.get());
    }


    public Map<String, Integer> getBotCounts() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, AtomicInteger> entry : botCounts.entrySet()) {
            result.put(entry.getKey(), entry.getValue().get());
        }
        return result;
    }

    public long getTotalRequests() {
        return totalLines.get();
    }
}
