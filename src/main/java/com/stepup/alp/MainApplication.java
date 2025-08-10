package com.stepup.alp;

import com.stepup.exeptions.LineLengthException;

import java.io.*;
import java.util.Scanner;


public class MainApplication {
    public static void main(String[] args) {

        int correctFileCount = 0;
        String filePath;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Введите путь к файлу: ");
            filePath = scanner.nextLine();
            File file = new File(filePath);

            if (!file.exists()) {
                System.out.println("Ошибка: файл не существует");
                continue;
            }

            if (file.isDirectory()) {
                System.out.println("Ошибка: указан путь к директории, а не к файлу");
                continue;
            }

            correctFileCount++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + correctFileCount);
            break;

        } while (true);

        try ( FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {

            int totalLines = 0;
            int maxLength = 0;
            int minLength = Integer.MAX_VALUE;
            String line;

            while ((line = reader.readLine()) != null) {
                totalLines++;
                int length = line.length();
                if (length > LineLengthException.MAX_LINE_LENGTH) throw new LineLengthException(length);
                maxLength = Math.max(maxLength, length);
                minLength = Math.min(minLength, length);
            }

            System.out.println("Общее количество строк: " + totalLines);
            System.out.println("Максимальная длина строки: " + maxLength);
            System.out.println("Минимальная длина строки: " + minLength);

        } catch (LineLengthException e) {
            System.err.println("Ошибка длины строки: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}

