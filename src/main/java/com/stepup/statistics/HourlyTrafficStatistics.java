package com.stepup.statistics;

import com.stepup.patterns.LogEntry;
import com.stepup.useragent.base.UserAgentInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class HourlyTrafficStatistics implements Statistics {

    // Для подсчета посещений реальными пользователями
    private final AtomicInteger humanVisits = new AtomicInteger(0);
    private final AtomicInteger errorRequests = new AtomicInteger(0);
    private final Set<String> uniqueIps = new HashSet<>();

    private String startTime;
    private String endTime;

    @Override
    public void addEntry(LogEntry entry) {
        // Обновляем временные метки
        String timestamp = entry.getTimestamp();
        if (startTime == null || timestamp.compareTo(startTime) < 0) {
            startTime = timestamp;
        }
        if (endTime == null || timestamp.compareTo(endTime) > 0) {
            endTime = timestamp;
        }


        // Проверяем на бота
        UserAgentInfo userAgent = entry.getUserAgent();
        if (userAgent != null && !userAgent.hasBot()) {
            humanVisits.incrementAndGet();
            uniqueIps.add(entry.getIp());

            // Подсчет ошибок
            int code = entry.getResponseCode();
            if (code >= 400 && code < 600) {
                errorRequests.incrementAndGet();
            }
        }
    }

    // Метод для расчета среднего количества посещений за час
    public double getAverageVisitsPerHour() {
        if (startTime == null || endTime == null) {
            return 0;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/MMM/yyyy:HH:mm:ss [Z]"
        ).withLocale(Locale.ENGLISH);
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);

        long hours = java.time.Duration.between(start, end).toHours();
        if (hours == 0) {
            return 0;
        }

        return (double) humanVisits.get() / hours;
    }

    // Метод для расчета среднего количества ошибок в час
    public double getAverageErrorsPerHour() {
        if (startTime == null || endTime == null) {
            return 0;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/MMM/yyyy:HH:mm:ss [Z]"
        ).withLocale(Locale.ENGLISH);
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);

        long hours = java.time.Duration.between(start, end).toHours();
        if (hours == 0) {
            return 0;
        }

        return (double) errorRequests.get() / hours;
    }

    // Метод для расчета средней посещаемости одним пользователем
    public double getAverageUserVisits() {
        if (uniqueIps.isEmpty()) {
            return 0;
        }
        return (double) humanVisits.get() / uniqueIps.size();
    }

    @Override
    public void printStatistics() {
        System.out.println("Статистика по часам:");
        System.out.println("-------------------");
        System.out.println("Период сбора данных: " + startTime + " - " + endTime);
        System.out.println("Среднее количество посещений в час: " + getAverageVisitsPerHour());
        System.out.println("Среднее количество ошибок в час: " + getAverageErrorsPerHour());
        System.out.println("Средняя посещаемость на пользователя: " + getAverageUserVisits());
    }
}
