package com.stepup.statistics;

import com.stepup.patterns.LogEntry;
import com.stepup.useragent.base.UserAgentInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

public class VisitStatistics implements Statistics {

    // Для подсчета пиковой посещаемости
    // В классе статистики используем ConcurrentHashMap
    private final ConcurrentHashMap<Integer, AtomicInteger> secondVisits = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AtomicInteger> ipVisits = new ConcurrentHashMap<>();
    private final ConcurrentSkipListSet<String> refererDomains = new ConcurrentSkipListSet<>();

    // В методе обработки записи добавляем синхронизацию
    @Override
    public void addEntry(LogEntry entry) {
        // Вся логика обработки
        UserAgentInfo userAgent = entry.getUserAgent();

        if (userAgent == null || userAgent.hasBot()) {
            return;
        }

        // Обработка времени
        int seconds = parseTimestampToSeconds(entry.getTimestamp());
        secondVisits.compute(seconds, (key, value) -> {
            if (value == null) return new AtomicInteger(1);
            value.incrementAndGet();
            return value;
        });

        // Обработка реферера
        String domain = extractDomain(entry.getReferer());
        if (domain != null && !domain.isEmpty()) refererDomains.add(domain);

        // Обработка IP - пользователей
        String ip = entry.getIp();
        ipVisits.compute(ip, (key, value) -> {
            if (value == null) return new AtomicInteger(1);
            value.incrementAndGet();
            return value;
        });
    }

    // Метод для расчета пиковой посещаемости
    public int getPeakVisitsPerSecond() {
        return secondVisits.values().stream()
                .mapToInt(AtomicInteger::get)
                .max()
                .orElse(0);
    }

    // Метод для получения списка рефереров - не используется
    public List<String> getRefererDomains() {
        return new ArrayList<>(refererDomains);
    }

    // Метод для расчета максимальной посещаемости одним пользователем
    public int getMaxUserVisits() {
        return ipVisits.values().stream()
                .mapToInt(AtomicInteger::get)
                .max()
                .orElse(0);
    }

    // Вспомогательные методы

    private int parseTimestampToSeconds(String timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/MMM/yyyy:HH:mm:ss [Z]"
        ).withLocale(Locale.ENGLISH);
        LocalDateTime dateTime = LocalDateTime.parse(timestamp, formatter);

        // Получаем секунды с начала дня
        return dateTime.getHour() * 3600 +
                dateTime.getMinute() * 60 +
                dateTime.getSecond();
    }

    private String extractDomain(String referer) {
        if (referer == null || referer.isEmpty()) return null;
        String domain = referer.replaceFirst("https?://", ""); // Удаляем протокол
        domain = domain.split("/")[0]; // Удаляем путь, путём выбора 1го элемента из массива до слеша
        return domain;
    }

    @Override
    public void printStatistics() {
        System.out.println("Статистика посещений:");
        System.out.println("------------------------");

        System.out.println("Пиковая посещаемость в секунду: " + getPeakVisitsPerSecond());
        System.out.println("Максимальная посещаемость одним пользователем: " + getMaxUserVisits());

        //getRefererDomains здесь не нужен, т.к. forEach сам понимает,
        // что нужно вывести элементы ConcurrentSkipListSet<String> refererDomains
        System.out.println("\nСайты-рефереры:");
        refererDomains.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
