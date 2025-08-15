package com.stepup.statistics;

import com.stepup.patterns.LogEntry;
import com.stepup.useragent.base.UserAgentInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentSkipListSet;

public class HourlyTrafficStatistics implements Statistics {
    private final ConcurrentHashMap<Integer, AtomicInteger> visitsByHour = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, AtomicInteger> errorsByHour = new ConcurrentHashMap<>();
    private final ConcurrentSkipListSet<String> uniqueUsers = new ConcurrentSkipListSet<>();

    private String startTime;
    private String endTime;

    @Override
    public void addEntry(LogEntry entry) {
        String timestamp = entry.getTimestamp();
        String ip = entry.getIp();

        // Обновляем временные метки
        if (startTime == null || timestamp.compareTo(startTime) < 0)
            startTime = timestamp;
        if (endTime == null || timestamp.compareTo(endTime) > 0)
            endTime = timestamp;

        int hour = extractHourFromTimestamp(timestamp);

        UserAgentInfo userAgent = entry.getUserAgent();
        if (userAgent != null && !userAgent.hasBot()) {
            visitsByHour.computeIfAbsent(hour, k -> new AtomicInteger()).incrementAndGet();
            uniqueUsers.add(ip);

            int code = entry.getResponseCode();
            if (code >= 400 && code < 600) {
                errorsByHour.computeIfAbsent(hour, k -> new AtomicInteger()).incrementAndGet();
            }
        }
    }

    private int extractHourFromTimestamp(String timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/MMM/yyyy:HH:mm:ss [Z]"
        ).withLocale(Locale.ENGLISH);
        LocalDateTime dateTime = LocalDateTime.parse(timestamp, formatter);
        return dateTime.getHour();
    }

    public double getAverageVisitsPerHour() {
        return calculateAverage(
                getTotalValue(visitsByHour),
                getTotalHours()
        );
    }

    // Метод для подсчета среднего количества ошибок в час
    public double getAverageErrorsPerHour() {
        return calculateAverage(
                getTotalValue(errorsByHour),
                getTotalHours()
        );
    }

    // Метод для подсчета среднего количества визитов на пользователя
    public double getAverageVisitsPerUser() {
        return calculateAverage(
                getTotalValue(visitsByHour),
                getUniqueUsersCount()
        );
    }

    private long getUniqueUsersCount() {
        return uniqueUsers.size();
    }

    private double calculateAverage(long totalValue, long divisor) {
        return divisor > 0 ? (double) totalValue / divisor : 0;
    }

    private long getTotalValue(ConcurrentHashMap<Integer, AtomicInteger> map) {
        return map.values().stream()
                .mapToInt(AtomicInteger::get)
                .sum();
    }

    private long getTotalHours() {
        if (startTime == null || endTime == null) {
            return 0;
        }

        LocalDateTime start = parseDateTime(startTime);
        LocalDateTime end = parseDateTime(endTime);

        return ChronoUnit.HOURS.between(start, end) + 1;
    }

    private LocalDateTime parseDateTime(String timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/MMM/yyyy:HH:mm:ss Z"
        ).withLocale(Locale.ENGLISH);
        return LocalDateTime.parse(timestamp, formatter);
    }

    @Override
    public void printStatistics() {
        System.out.println("Статистика трафика:");
        System.out.println("------------------");

        if (startTime == null || endTime == null) {
            System.out.println("Данные отсутствуют");
            return;
        }

        System.out.println("Период сбора данных: " + startTime + " - " + endTime);
        System.out.println();

        // Общая информация
        System.out.println("Общая статистика:");
        System.out.println("----------------");
        System.out.printf("Среднее количество посещений в час: %.2f%n", getAverageVisitsPerHour());
        System.out.printf("Среднее количество ошибок в час: %.2f%n", getAverageErrorsPerHour());
        System.out.printf("Средняя посещаемость на пользователя: %.2f%n", getAverageVisitsPerUser());
        System.out.println();

        // Детальная почасовая статистика
        System.out.println("Почасовая статистика посещений:");
        System.out.println("-----------------------------");
        printHourlyStatistics(visitsByHour, "Посещений");

        System.out.println();

        System.out.println("Почасовая статистика ошибок:");
        System.out.println("--------------------------");
        printHourlyStatistics(errorsByHour, "Ошибок");

        System.out.println();
        System.out.println();
    }

    private void printHourlyStatistics(ConcurrentHashMap<Integer, AtomicInteger> map, String type) {
        // Получаем все часы в периоде
        LocalDateTime start = parseDateTime(startTime);
        LocalDateTime end = parseDateTime(endTime);

        LocalDateTime current = start.withMinute(0).withSecond(0);
        LocalDateTime limit = end.withMinute(0).withSecond(0).plusHours(1);

        while (current.isBefore(limit)) {
            int hour = current.getHour();
            int count = map.getOrDefault(hour, new AtomicInteger(0)).get();
            System.out.printf("Час %02d:00 - %d %s%n", hour, count, type);
            current = current.plusHours(1);
        }
    }

    @Override
    public String toString() {
        return "HourlyTrafficStatistics{" +
                "visitsByHour=" + visitsByHour +
                ", errorsByHour=" + errorsByHour +
                ", uniqueUsers=" + uniqueUsers.size() +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
