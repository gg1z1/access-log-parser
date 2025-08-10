package com.stepup.parsers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BotStatistics {
    // Константы для известных ботов
    private static final String GOOGLEBOT = "Googlebot";
    private static final String YANDEXBOT = "YandexBot";


    // Счетчики
    private final AtomicInteger totalLines = new AtomicInteger(0);
    private final Map<String, AtomicInteger> botCounts = new HashMap<>();

    public BotStatistics() {
        // Инициализация счетчиков для известных ботов
        botCounts.put(GOOGLEBOT, new AtomicInteger(0));
        botCounts.put(YANDEXBOT, new AtomicInteger(0));
        botCounts.put("Unknown", new AtomicInteger(0));
    }

    /**
     * Обработка запроса от бота
     */
    public void processBot(String botName) {
        totalLines.incrementAndGet();

        // Если бот известен, увеличиваем его счетчик
        if (botCounts.containsKey(botName)) {
            botCounts.get(botName).incrementAndGet();
        } else {
            // Для неизвестных ботов используем счетчик Unknown
            botCounts.get("Unknown").incrementAndGet();
        }
    }

    /**
     * Вывод статистики в консоль
     */
    public void printStatistics() {
        if (totalLines.get() == 0) {
            System.out.println("Файл пуст");
            return;
        }

        System.out.println("Статистика запросов ботов:");
        System.out.println("-------------------------");

        // Выводим статистику по каждому боту
        for (Map.Entry<String, AtomicInteger> entry : botCounts.entrySet()) {
            String botName = entry.getKey();
            int count = entry.getValue().get();
            if (count > 0) {
                double percentage = (double) count / totalLines.get() * 100;

                System.out.printf("""
                        %-15s: %d (%6.2f%%)%n
                        """,
                        botName, count, percentage);
            }
        }

        System.out.println("-------------------------");
        System.out.println("Общее количество строк: " + totalLines.get());
    }

}
