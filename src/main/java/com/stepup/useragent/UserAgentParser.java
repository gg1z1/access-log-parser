package com.stepup.useragent;

public class UserAgentParser {

    // Метод для извлечения информации о боте
    public static String extractBotInfo(String userAgent) {
        // Проверка входных данных
        if (userAgent == null || userAgent.isEmpty()) return null;

        // Поиск позиции открывающей скобки
        int start = userAgent.indexOf('(');

        // Поиск позиции закрывающей скобки, начиная с позиции открывающей
        int end = userAgent.indexOf(')', start);

        // Проверка наличия обеих скобок
        if (start == -1 || end == -1) return null;

        // Извлечение текста между скобками
        String firstBrackets = userAgent.substring(start + 1, end);

        // Разделение текста по символу ';'
        String[] parts = firstBrackets.split(";");

        // Проверка наличия минимум двух частей после разделения
        if (parts.length < 2) return null;

        // Получение второй части и удаление пробелов
        String fragment = parts[1].trim();

        // Поиск символа '/'
        int slashIndex = fragment.indexOf('/');

        // Если символ '/' найден, обрезаем строку до него
        if (slashIndex != -1) fragment = fragment.substring(0, slashIndex);

        // Возвращаем результат
        return fragment;
    }
}