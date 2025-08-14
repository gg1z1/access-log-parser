package com.stepup.statistics;

import com.stepup.patterns.LogEntry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.HashMap;

public class TrafficStatistics implements Statistics {

    private final AtomicLong totalBytes = new AtomicLong(0);
    private final AtomicInteger totalRequests = new AtomicInteger(0);
    private String startTime;
    private String endTime;
    private final Map<Integer, AtomicInteger> statusCodes = new HashMap<>();

    // Форматировщик даты для парсинга
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");

    public TrafficStatistics() {
        // Инициализация счетчиков кодов ответа
        statusCodes.put(200, new AtomicInteger(0));
        statusCodes.put(301, new AtomicInteger(0));
        statusCodes.put(302, new AtomicInteger(0));
        statusCodes.put(404, new AtomicInteger(0));
        statusCodes.put(500, new AtomicInteger(0));
        statusCodes.put(999, new AtomicInteger(0));
    }

    @Override
    public void addEntry(LogEntry entry) {
        // Добавление размера ответа
        totalBytes.addAndGet(entry.getContentLength());
        totalRequests.incrementAndGet();

        // Обновление временных меток
        String timestamp = entry.getTimestamp();
        if (startTime == null || timestamp.compareTo(startTime) < 0) {
            startTime = timestamp;
        }
        if (endTime == null || timestamp.compareTo(endTime) > 0) {
            endTime = timestamp;
        }

        // Подсчет кодов ответа
        int code = entry.getResponseCode();
        if (statusCodes.containsKey(code)) {
            statusCodes.get(code).incrementAndGet();
        } else {
            statusCodes.get(999).incrementAndGet();
        }
    }

    @Override
    public void printStatistics() {
        if (totalRequests.get() == 0) {
            System.out.println("Файл пуст");
            return;
        }

        System.out.println("Статистика трафика:");
        System.out.println("-------------------");

        // Добавляем новую строку с трафиком
        double trafficRate = getTrafficRate();
        System.out.println("Средний трафик в час: " + formatBytes((long)trafficRate));

        System.out.println("Общее количество запросов: " + totalRequests.get());
        System.out.println("Общий объем трафика: " + formatBytes(totalBytes.get()));
        System.out.println("Период сбора данных: " + startTime + " - " + endTime);

        System.out.println("\nРаспределение по кодам ответа:");
        for (Map.Entry<Integer, AtomicInteger> entry : statusCodes.entrySet()) {
            int code = entry.getKey();
            int count = entry.getValue().get();
            if (count > 0) {
                double percentage = (double) count / totalRequests.get() * 100;
                System.out.printf("Код %-3d: %d запросов (%6.2f%%)%n",
                        code, count, percentage);
            }
        }
    }

    // Метод расчета трафика
    private double getTrafficRate() {
        if (startTime == null || endTime == null) {
            return 0.0;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");
        try {
            LocalDateTime start = LocalDateTime.parse(startTime, formatter);
            LocalDateTime end = LocalDateTime.parse(endTime, formatter);
            long durationHours = java.time.Duration.between(start, end).toHours();

            if (durationHours <= 0) {
                return 0.0;
            }

            return (double) totalBytes.get() / durationHours;
        } catch (Exception e) {
            return 0.0;
        }
    }

    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.2f KB", (double) bytes / 1024);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.2f MB", (double) bytes / (1024 * 1024));
        return String.format("%.2f GB", (double) bytes / (1024 * 1024 * 1024));
    }

    private double getAverageTrafficRate() {
        if (startTime == null || endTime == null) {
            return 0;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z");
            LocalDateTime start = LocalDateTime.parse(startTime, formatter);
            LocalDateTime end = LocalDateTime.parse(endTime, formatter);

            long durationHours = java.time.Duration.between(start, end).toHours();
            if (durationHours == 0) {
                return 0;
            }

            return (double) totalBytes.get() / durationHours;
        } catch (Exception e) {
            return 0;
        }
    }

    // Геттер для среднего трафика
    public long getAverageTrafficRateBytes() {
        return (long)getAverageTrafficRate();
    }

    // Дополнительные методы для статистики
    public double getAverageResponseSize() {
        if (totalRequests.get() == 0) return 0;
        return (double) totalBytes.get() / totalRequests.get();
    }

    public int getTotalUniqueStatusCodes() {
        return statusCodes.size();
    }

    public boolean hasData() {
        return totalRequests.get() > 0;
    }
}
