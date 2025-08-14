package com.stepup.statistics;

import com.stepup.patterns.LogEntry;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class PageStatistics implements Statistics{

    // ... создайте в классе переменную класса HashSet...
    // Для хранения уникальных URL страниц с кодом 200
    private final HashSet<String> uniquePages = new HashSet<>();

    // Для подсчета ОС
    // ... создайте в классе переменную класса HashMap<String, Integer> ...
    private final Map<String, Integer> osCount = new HashMap<>();
    private int totalRequests = 0;

    @Override
    public void addEntry(LogEntry entry) {
        // ... В эту переменную при выполнении метода addEntry
        // добавляйте адреса существующих страниц (с кодом ответа 200) сайта. ...
        // Добавляем страницу, если код ответа 200
        if (entry.getResponseCode() == 200) uniquePages.add(entry.getRequestPath());
        // Подсчитываем ОС
        if(entry.getUserAgent().hasBrowser()){
            String os = entry.getUserAgent().getBrowserInfo().getOs();

            // Группировка ОС
            String groupedOs = groupOs(os);
            // ... в которой подсчитывайте частоту встречаемости каждой операционной системы ...
            // ... При выполнении метода addEntry проверяйте, есть ли в этом HashMap запись с такой операционной системой.
            // Если нет, вставляйте такую запись.
            // Если есть, добавляйте к соответствующему значению единицу.
            // В итоге получится HashMap, ключи которого будут названиями операционных систем
            // , а значения — их количествами в лог-файле.
            // TUMANOV AS: getOrDefault классный метод, который возвращает 0 в случае если OS не найдена.
            // TUMANOV AS: Так что можно не проверять если ОС в этом коллекторе, вернёт 0 если нет.
            osCount.put(groupedOs, osCount.getOrDefault(groupedOs, 0) + 1);
            totalRequests++;
        }
    }

    @Override
    public void printStatistics() {
        System.out.println("Статистика страниц и ОС:");
        System.out.println("------------------------");

        System.out.println("\nУникальные страницы сайта:");
        System.out.println("Всего уникальных страниц: " + uniquePages.size());

        System.out.println("\nСтатистика операционных систем:");
        Map<String, Double> osStats = getOsStatistics();
        for (Map.Entry<String, Double> entry : osStats.entrySet()) {
            System.out.printf("%-15s: %6.2f%%%n",
                    entry.getKey(), entry.getValue() * 100);
        }
    }

    private String groupOs(String os) {
        if (os.contains("Windows")) {
            return "Windows";
        } else if (os.contains("Macintosh") || os.contains("Mac OS")) {
            return "macOS";
        } else if (os.contains("Linux") || os.contains("Android")) {
            return "Linux/Android";
        } else if (os.contains("X11") || os.contains("CrOS")) {
            return "Unix-like";
        } else if (os.contains("Unknown") || os.isEmpty()) {
            return "Unknown";
        } else {
            return os;
        }
    }

    // ... В классе Statistics реализуйте метод,
    // который будет возвращать список всех существующих страниц сайта ...
    // Метод для получения списка всех страниц
    public HashSet<String> getUniquePages() { return new HashSet<>(uniquePages); }

    // Метод для получения статистики по ОС
    public Map<String, Double> getOsStatistics() {
        Map<String, Double> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : osCount.entrySet()) {
            double percentage = (double) entry.getValue() / totalRequests;
            result.put(entry.getKey(), percentage);
        }

        return result;
    }

    // Дополнительный метод для детального просмотра страниц
    public void printUniquePages() {
        System.out.println("Список всех уникальных страниц:");
        for (String page : getUniquePages()) {
            System.out.println(page);
        }
    }

}
