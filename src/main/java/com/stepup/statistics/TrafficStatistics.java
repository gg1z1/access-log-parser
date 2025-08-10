package com.stepup.statistics;

import com.stepup.patterns.LogEntry;

import java.time.LocalDateTime;
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

    public TrafficStatistics() {
        // Инициализируем счетчики для основных кодов ответа
        statusCodes.put(200, new AtomicInteger(0));
        statusCodes.put(301, new AtomicInteger(0));
        statusCodes.put(302, new AtomicInteger(0));
        statusCodes.put(404, new AtomicInteger(0));
        statusCodes.put(500, new AtomicInteger(0));
        statusCodes.put(999, new AtomicInteger(0)); // Для остальных кодов
    }

    @Override
    public void addEntry(LogEntry entry) {
        // Добавляем размер ответа к общему объему
        totalBytes.addAndGet(entry.getContentLength());

        // Увеличиваем счетчик запросов
        totalRequests.incrementAndGet();

        // Обновляем временные метки
        String timestamp = entry.getTimestamp();
        if (startTime == null || timestamp.compareTo(startTime) < 0) {
            startTime = timestamp;
        }
        if (endTime == null || timestamp.compareTo(endTime) > 0) {
            endTime = timestamp;
        }

        // Подсчитываем коды ответа
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

    private String formatBytes(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return String.format("%.2f KB", (double) bytes / 1024);
        if (bytes < 1024 * 1024 * 1024) return String.format("%.2f MB", (double) bytes / (1024 * 1024));
        return String.format("%.2f GB", (double) bytes / (1024 * 1024 * 1024));
    }


    public long getTotalRequests() {
        return totalRequests.get();
    }

    // Дополнительные геттеры
    public long getTotalBytes() {
        return totalBytes.get();
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Map<Integer, Integer> getStatusCodes() {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, AtomicInteger> entry : statusCodes.entrySet()) {
            result.put(entry.getKey(), entry.getValue().get());
        }
        return result;
    }

    public int getStatusCodeCount(int code) {
        return statusCodes.getOrDefault(code, new AtomicInteger(0)).get();
    }

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
