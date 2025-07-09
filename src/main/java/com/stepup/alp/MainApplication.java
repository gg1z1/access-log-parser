package com.stepup.alp;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {

////задание 1
//// Тестовый случай 1: базовый случай
//        System.out.println("Тестовый случай 1: базовый случай");
//        System.out.println("Вводим: listNums(0)");
//        System.out.println("Ожидаемый результат: \"0\"");
//        System.out.println("Фактический результат: \"" + listNums(0) + "\"");
//
//// Тестовый случай 2: простое число
//        System.out.println("\nТестовый случай 2: простое число");
//        System.out.println("Вводим: listNums(5)");
//        System.out.println("Ожидаемый результат: \"0 1 2 3 4 5\"");
//        System.out.println("Фактический результат: \"" + listNums(5) + "\"");
//
//// Тестовый случай 3: однозначное число
//        System.out.println("\nТестовый случай 3: однозначное число");
//        System.out.println("Вводим: listNums(1)");
//        System.out.println("Ожидаемый результат: \"0 1\"");
//        System.out.println("Фактический результат: \"" + listNums(1) + "\"");
//
//// Тестовый случай 4: двузначное число
//        System.out.println("\nТестовый случай 4: двузначное число");
//        System.out.println("Вводим: listNums(10)");
//        System.out.println("Ожидаемый результат: \"0 1 2 3 4 5 6 7 8 9 10\"");
//        System.out.println("Фактический результат: \"" + listNums(10) + "\"");
//
//
//// Тестовый случай 7: минимальное значение
//        System.out.println("\nТестовый случай 7: минимальное значение");
//        System.out.println("Вводим: listNums(0)");
//        System.out.println("Ожидаемый результат: \"0\"");
//        System.out.println("Фактический результат: \"" + listNums(0) + "\"");
//
//// Тестовый случай 8: проверка пробелов
//        System.out.println("\nТестовый случай 8: проверка пробелов");
//        System.out.println("Вводим: listNums(2)");
//        System.out.println("Ожидаемый результат: \"0 1 2\" (пробелы между числами)");
//        System.out.println("Фактический результат: \"" + listNums(2) + "\"");
//        //задание 2
//        // Тест 1: базовый случай
//        System.out.println("Тестовый случай 1: базовый случай с положительным числом");
//        System.out.println("Вводим: reverseListNums(5)");
//        System.out.println("Ожидаемый результат: \"5 4 3 2 1 0\"");
//        System.out.println("Фактический результат: \"" + reverseListNums(5) + "\"");
//
//        // Тест 2: минимальное значение
//        System.out.println("\nТестовый случай 2: минимальное значение (0)");
//        System.out.println("Вводим: reverseListNums(0)");
//        System.out.println("Ожидаемый результат: \"0\"");
//        System.out.println("Фактический результат: \"" + reverseListNums(0) + "\"");
//
//        // Тест 3: небольшое положительное число
//        System.out.println("\nТестовый случай 3: небольшое положительное число");
//        System.out.println("Вводим: reverseListNums(3)");
//        System.out.println("Ожидаемый результат: \"3 2 1 0\"");
//        System.out.println("Фактический результат: \"" + reverseListNums(3) + "\"");
//
//        // Тест 4: число больше 10
//        System.out.println("\nТестовый случай 4: число больше 10");
//        System.out.println("Вводим: reverseListNums(12)");
//        System.out.println("Ожидаемый результат: \"12 11 10 9 8 7 6 5 4 3 2 1 0\"");
//        System.out.println("Фактический результат: \"" + reverseListNums(12) + "\"");
//
//        // Тест 5: проверка форматирования (пробелы)
//        System.out.println("\nТестовый случай 5: проверка форматирования");
//        System.out.println("Вводим: reverseListNums(2)");
//        System.out.println("Ожидаемый результат: \"2 1 0\" (без лишних пробелов)");
//        System.out.println("Фактический результат: \"" + reverseListNums(2) + "\"");
//
//        // Тест 6: проверка граничного случая
//        System.out.println("\nТестовый случай 6: граничное значение");
//        System.out.println("Вводим: reverseListNums(1)");
//        System.out.println("Ожидаемый результат: \"1 0\"");
//        System.out.println("Фактический результат: \"" + reverseListNums(1) + "\"");

        //задание 3
// Тестовый случай 1: базовый случай с нечетным числом
        System.out.println("Тестовый случай 1: базовый случай с нечетным числом");
        System.out.println("Вводим: chet(9)");
        System.out.println("Ожидаемый результат: 0 2 4 6 8");
        System.out.println("Фактический результат: " + chet(9));

// Тестовый случай 2: базовый случай с четным числом
        System.out.println("\nТестовый случай 2: базовый случай с четным числом");
        System.out.println("Вводим: chet(10)");
        System.out.println("Ожидаемый результат: 0 2 4 6 8 10");
        System.out.println("Фактический результат: " + chet(10));

// Тестовый случай 3: минимальное значение
        System.out.println("\nТестовый случай 3: минимальное значение");
        System.out.println("Вводим: chet(0)");
        System.out.println("Ожидаемый результат: 0");
        System.out.println("Фактический результат: " + chet(0));

//// Тестовый случай 4: отрицательное число
//        System.out.println("\nТестовый случай 4: отрицательное число");
//        System.out.println("Вводим: chet(-5)");
//        System.out.println("Ожидаемый результат: (пустая строка)");
//        System.out.println("Фактический результат: \"" + chet(-5) + "\"");

// Тестовый случай 5: большое число
        System.out.println("\nТестовый случай 5: большое число");
        System.out.println("Вводим: chet(20)");
        System.out.println("Ожидаемый результат: 0 2 4 6 8 10 12 14 16 18 20");
        System.out.println("Фактический результат: " + chet(20));

// Тестовый случай 6: единица
        System.out.println("\nТестовый случай 6: единица");
        System.out.println("Вводим: chet(1)");
        System.out.println("Ожидаемый результат: 0");
        System.out.println("Фактический результат: " + chet(1));

// Тестовый случай 7: проверка на четность границы
        System.out.println("\nТестовый случай 7: проверка на четность границы");
        System.out.println("Вводим: chet(12)");
        System.out.println("Ожидаемый результат: 0 2 4 6 8 10 12");
        System.out.println("Фактический результат: " + chet(12));

// Тестовый случай 8: проверка на нечетность границы
        System.out.println("\nТестовый случай 8: проверка на нечетность границы");
        System.out.println("Вводим: chet(13)");
        System.out.println("Ожидаемый результат: 0 2 4 6 8 10 12");
        System.out.println("Фактический результат: " + chet(13));
    }

    public static String chet(int x) {
        StringBuilder result = new StringBuilder();
        // Используем цикл с шагом 2, чтобы получать только чётные числа
        // как на видео по учебному материалу
        for (int i = 0; i <= x; i += 2) {result.append(i + " ");}
        return result.deleteCharAt(result.length() - 1).toString();
    }

    public static String reverseListNums(int x) {
        // Создаем StringBuilder для эффективной работы со строками
        StringBuilder result = new StringBuilder();

        // Проходим от x до 0 включительно
        for (int i = x; i >= 0; i--) {result.append(i + " ");}

        // Возвращаем результат в виде строки
        return result.deleteCharAt(result.length() - 1).toString();
    }

    public static String listNums(int x) {
        // Создаем StringBuilder для конкатенации строк
        StringBuilder result = new StringBuilder();

        // Проходим по всем числам от 0 до x включительно
        for (int i = 0; i <= x; i++) {result.append(i + " ");}

        // Возвращаем итоговую строку, обрезаем пробел в конце
        return result.deleteCharAt(result.length() - 1).toString();
    }
}
