package com.stepup.statistics;

import com.stepup.patterns.LogEntry;
import com.stepup.useragent.base.UserAgentInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BotStatistics implements Statistics {
    private final Map<String, AtomicInteger> botCounts = new HashMap<>();
    private final AtomicInteger totalRequests = new AtomicInteger(0);
    private final AtomicInteger botRequests = new AtomicInteger(0);
    private final AtomicInteger nonBotRequests = new AtomicInteger(0);

    @Override
    public void addEntry(LogEntry entry) {
        UserAgentInfo userAgent = entry.getUserAgent();
        if (userAgent == null) return;

        totalRequests.incrementAndGet();

        if(userAgent.hasBot()) {
            botRequests.incrementAndGet();
            String botName = userAgent.getBotInfo().getBotName();

            // Используем getOrDefault для корректной работы с AtomicInteger
            botCounts.compute(botName, (name, count) -> {
                if (count == null) {
                    return new AtomicInteger(1);
                } else {
                    count.incrementAndGet();
                    return count;
                }
            });
        } else {
            nonBotRequests.incrementAndGet();
        }
    }

    @Override
    public void printStatistics() {
        if (totalRequests.get() == 0) {
            System.out.println("Файл пуст");
            return;
        }

        System.out.println("Статистика ботов и запросов:");
        System.out.println("----------------------------");

        System.out.println("Общее количество запросов: " + totalRequests.get());
        System.out.println("Запросы от ботов: " + botRequests.get() +
                " (" + getPercentage(botRequests.get(), totalRequests.get()) + "%)");
        System.out.println("Запросы от пользователей: " + nonBotRequests.get() +
                " (" + getPercentage(nonBotRequests.get(), totalRequests.get()) + "%)");

        System.out.println("\nРаспределение по ботам:");
        for (Map.Entry<String, AtomicInteger> entry : botCounts.entrySet()) {
            String botName = entry.getKey();
            int count = entry.getValue().get();
            double botPercentage = getPercentage(count, botRequests.get());
            System.out.printf("%-15s: %d (%6.2f%%)%n", botName, count, botPercentage);
        }
    }

    private double getPercentage(int part, int total) {
        return (double) part / total * 100;
    }

    public Map<String, Integer> getBotCounts() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, AtomicInteger> entry : botCounts.entrySet()) {
            result.put(entry.getKey(), entry.getValue().get());
        }
        return result;
    }

    public int getTotalRequests() {
        return totalRequests.get();
    }

    public int getBotRequests() {
        return botRequests.get();
    }

    public int getNonBotRequests() {
        return nonBotRequests.get();
    }
}