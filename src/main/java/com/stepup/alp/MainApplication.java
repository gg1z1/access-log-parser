package com.stepup.alp;

import java.util.Scanner;
import java.io.File;

public class MainApplication {
    public static void main(String[] args) {

        //без ошибки
        openFile2("src/main/resources/access.log");
        //директория
        openFile2("src/main/resources/");
        //ошибка в названии
        openFile2("src/main/resources/access_error_name.log");

        //рабочий вариант
        openFile();

    }
    public static void openFile(){
        // Счетчик корректных файлов
        int correctFileCount = 0;

        // Бесконечный цикл
        while (true) {
            // Чтение пути из консоли
            System.out.print("Введите путь к файлу: ");
            String filePath;
            filePath = new Scanner(System.in).nextLine();
            //filePath = path;

            // Создание объекта File и проверка существования
            File file = new File(filePath);
            boolean isFileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            // Проверка условий с использованием continue
            if (!isFileExists) {
                System.out.println("Ошибка: файл не существует");
                continue;
                //break;
            }

            if (isDirectory) {
                System.out.println("Ошибка: указан путь к директории, а не к файлу");
                continue;
                //break;
            }

            // Обработка корректного файла
            correctFileCount++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + correctFileCount);
            continue;
            //break;
        }
    }

    public static void openFile2(String path){
        // Счетчик корректных файлов
        int correctFileCount = 0;

        // Бесконечный цикл
        while (true) {
            // Чтение пути из консоли
            System.out.print("Введите путь к файлу: ");
            String filePath;
            //filePath = new Scanner(System.in).nextLine();
            filePath = path;

            // Создание объекта File и проверка существования
            File file = new File(filePath);
            boolean isFileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            // Проверка условий с использованием continue
            if (!isFileExists) {
                System.out.println("Ошибка: файл не существует");
                //continue;
                break;
            }

            if (isDirectory) {
                System.out.println("Ошибка: указан путь к директории, а не к файлу");
                //continue;
                break;
            }

            // Обработка корректного файла
            correctFileCount++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + correctFileCount);
            break;
        }
    }
}
