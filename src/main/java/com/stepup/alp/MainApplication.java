package com.stepup.alp;

import java.util.Scanner;
import java.io.File;

public class MainApplication {
    public static void main(String[] args) {

        //рабочий вариант
        openFile();

    }

    public static void openFile(){
        // Счетчик корректных файлов
        int correctFileCount = 0;

        // Бесконечный цикл
        // О боже, из него невозможно выбраться
        while (true) {
            // Чтение пути из консоли и запись в строку
            System.out.print("Введите путь к файлу: ");
            String filePath;
            filePath = new Scanner(System.in).nextLine();

            // Создание объекта File по указанному пути
            File file = new File(filePath);
            // Переменные boolean для проверки коррекности файла
            boolean isFileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            // Проверка существования файла
            // Если файла нет, то строка с текстом ошибки
            if (!isFileExists) {
                System.out.println("Ошибка: файл не существует");
                continue;
            }
            // Проверка директории
            // Если это директория, то строка с текстом ошибки
            if (isDirectory) {
                System.out.println("Ошибка: указан путь к директории, а не к файлу");
                continue;
            }

            // Обработка корректного файла
            correctFileCount++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + correctFileCount);
            // всё по новой босс.
            continue;
        }
    }

}

