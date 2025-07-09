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

//        //задание 3
//// Тестовый случай 1: базовый случай с нечетным числом
//        System.out.println("Тестовый случай 1: базовый случай с нечетным числом");
//        System.out.println("Вводим: chet(9)");
//        System.out.println("Ожидаемый результат: 0 2 4 6 8");
//        System.out.println("Фактический результат: " + chet(9));
//
//// Тестовый случай 2: базовый случай с четным числом
//        System.out.println("\nТестовый случай 2: базовый случай с четным числом");
//        System.out.println("Вводим: chet(10)");
//        System.out.println("Ожидаемый результат: 0 2 4 6 8 10");
//        System.out.println("Фактический результат: " + chet(10));
//
//// Тестовый случай 3: минимальное значение
//        System.out.println("\nТестовый случай 3: минимальное значение");
//        System.out.println("Вводим: chet(0)");
//        System.out.println("Ожидаемый результат: 0");
//        System.out.println("Фактический результат: " + chet(0));
//
////// Тестовый случай 4: отрицательное число
////        System.out.println("\nТестовый случай 4: отрицательное число");
////        System.out.println("Вводим: chet(-5)");
////        System.out.println("Ожидаемый результат: (пустая строка)");
////        System.out.println("Фактический результат: \"" + chet(-5) + "\"");
//
//// Тестовый случай 5: большое число
//        System.out.println("\nТестовый случай 5: большое число");
//        System.out.println("Вводим: chet(20)");
//        System.out.println("Ожидаемый результат: 0 2 4 6 8 10 12 14 16 18 20");
//        System.out.println("Фактический результат: " + chet(20));
//
//// Тестовый случай 6: единица
//        System.out.println("\nТестовый случай 6: единица");
//        System.out.println("Вводим: chet(1)");
//        System.out.println("Ожидаемый результат: 0");
//        System.out.println("Фактический результат: " + chet(1));
//
//// Тестовый случай 7: проверка на четность границы
//        System.out.println("\nТестовый случай 7: проверка на четность границы");
//        System.out.println("Вводим: chet(12)");
//        System.out.println("Ожидаемый результат: 0 2 4 6 8 10 12");
//        System.out.println("Фактический результат: " + chet(12));
//
//// Тестовый случай 8: проверка на нечетность границы
//        System.out.println("\nТестовый случай 8: проверка на нечетность границы");
//        System.out.println("Вводим: chet(13)");
//        System.out.println("Ожидаемый результат: 0 2 4 6 8 10 12");
//        System.out.println("Фактический результат: " + chet(13));
//        //задание 4
//        // Тест 1: базовая степень
//        System.out.println("Тестовый случай 1: возведение в положительную степень");
//        System.out.println("Вводим: pow(2, 5)");
//        System.out.println("Ожидаемый результат: 32");
//        System.out.println("Фактический результат: " + pow(2, 5));
//        System.out.println();
//
//        // Тест 2: степень 0
//        System.out.println("Тестовый случай 2: возведение в нулевую степень");
//        System.out.println("Вводим: pow(5, 0)");
//        System.out.println("Ожидаемый результат: 1");
//        System.out.println("Фактический результат: " + pow(5, 0));
//        System.out.println();
//
//        // Тест 3: степень 1
//        System.out.println("Тестовый случай 3: возведение в первую степень");
//        System.out.println("Вводим: pow(7, 1)");
//        System.out.println("Ожидаемый результат: 7");
//        System.out.println("Фактический результат: " + pow(7, 1));
//        System.out.println();
//
//        // Тест 4: единица в степени
//        System.out.println("Тестовый случай 4: единица в степени");
//        System.out.println("Вводим: pow(1, 10)");
//        System.out.println("Ожидаемый результат: 1");
//        System.out.println("Фактический результат: " + pow(1, 10));
//        System.out.println();
//
//        // Тест 5: отрицательное основание
//        System.out.println("Тестовый случай 5: отрицательное основание");
//        System.out.println("Вводим: pow(-2, 3)");
//        System.out.println("Ожидаемый результат: -8");
//        System.out.println("Фактический результат: " + pow(-2, 3));
//        System.out.println();
//
//        // Тест 6: четная степень отрицательного числа
//        System.out.println("Тестовый случай 6: четная степень отрицательного числа");
//        System.out.println("Вводим: pow(-3, 2)");
//        System.out.println("Ожидаемый результат: 9");
//        System.out.println("Фактический результат: " + pow(-3, 2));
//        System.out.println();
//
//        // Тест 7: большие числа
//        System.out.println("Тестовый случай 7: большие числа");
//        System.out.println("Вводим: pow(10, 5)");
//        System.out.println("Ожидаемый результат: 100000");
//        System.out.println("Фактический результат: " + pow(10, 5));
//        System.out.println();
//        //задание 5
//        // Тест 1: базовое число
//        System.out.println("Тестовый случай 1: базовое положительное число");
//        System.out.println("Вводим: numLen(12345)");
//        System.out.println("Ожидаемый результат: 5");
//        System.out.println("Фактический результат: " + numLen(12345));
//        System.out.println();
//
//        // Тест 2: число с нулями в конце
//        System.out.println("Тестовый случай 2: число с нулями в конце");
//        System.out.println("Вводим: numLen(1000)");
//        System.out.println("Ожидаемый результат: 4");
//        System.out.println("Фактический результат: " + numLen(1000));
//        System.out.println();
//
//        // Тест 3: минимальное значение (0)
//        System.out.println("Тестовый случай 3: минимальное значение");
//        System.out.println("Вводим: numLen(0)");
//        System.out.println("Ожидаемый результат: 1");
//        System.out.println("Фактический результат: " + numLen(0));
//        System.out.println();
//
//        // Тест 4: большое число
//        System.out.println("Тестовый случай 4: большое число");
//        System.out.println("Вводим: numLen(987654321)");
//        System.out.println("Ожидаемый результат: 9");
//        System.out.println("Фактический результат: " + numLen(987654321));
//        System.out.println();
//
//        // Тест 5: число с одной цифрой
//        System.out.println("Тестовый случай 5: однозначное число");
//        System.out.println("Вводим: numLen(9)");
//        System.out.println("Ожидаемый результат: 1");
//        System.out.println("Фактический результат: " + numLen(9));
//        System.out.println();
//
//        // Тест 6: число с несколькими нулями
//        System.out.println("Тестовый случай 6: число с несколькими нулями");
//        System.out.println("Вводим: numLen(100100)");
//        System.out.println("Ожидаемый результат: 6");
//        System.out.println("Фактический результат: " + numLen(100100));
//        System.out.println();
//
//        // Тест 7: максимально возможное значение long
//        System.out.println("Тестовый случай 7: максимально возможное значение");
//        System.out.println("Вводим: numLen(Long.MAX_VALUE)");
//        System.out.println("Ожидаемый результат: 19");
//        System.out.println("Фактический результат: " + numLen(Long.MAX_VALUE));
//        System.out.println();
//        //задание 6
//        // Тестирование функции equalNum
//        System.out.println("Тестирование функции equalNum");
//
//        // Тест 1: все цифры одинаковые
//        System.out.println("\nТестовый случай 1: все цифры одинаковые");
//        System.out.println("Вводим: equalNum(1111)");
//        System.out.println("Ожидаемый результат: true");
//        System.out.println("Фактический результат: " + equalNum(1111));
//
//        // Тест 2: разные цифры
//        System.out.println("\nТестовый случай 2: разные цифры");
//        System.out.println("Вводим: equalNum(1234)");
//        System.out.println("Ожидаемый результат: false");
//        System.out.println("Фактический результат: " + equalNum(1234));
//
//        // Тест 3: отрицательное число с одинаковыми цифрами
//        System.out.println("\nТестовый случай 3: отрицательное число");
//        System.out.println("Вводим: equalNum(-5555)");
//        System.out.println("Ожидаемый результат: true");
//        System.out.println("Фактический результат: " + equalNum(-5555));
//
//        // Тест 4: число с нулями
//        System.out.println("\nТестовый случай 4: число с нулями");
//        System.out.println("Вводим: equalNum(0000)");
//        System.out.println("Ожидаемый результат: true");
//        System.out.println("Фактический результат: " + equalNum(0000));
//
//        // Тест 5: однозначное число
//        System.out.println("\nТестовый случай 5: однозначное число");
//        System.out.println("Вводим: equalNum(7)");
//        System.out.println("Ожидаемый результат: true");
//        System.out.println("Фактический результат: " + equalNum(7));
//
//        // Тест 6: число с разными цифрами в середине
//        System.out.println("\nТестовый случай 6: разные цифры в середине");
//        System.out.println("Вводим: equalNum(8898)");
//        System.out.println("Ожидаемый результат: false");
//        System.out.println("Фактический результат: " + equalNum(8898));
//
//        // Тест 7: большое число
//        System.out.println("\nТестовый случай 7: большое число");
//        System.out.println("Вводим: equalNum(66666666)");
//        System.out.println("Ожидаемый результат: true");
//        System.out.println("Фактический результат: " + equalNum(66666666));
//
//        // Тест 8: 0
//        System.out.println("\nТестовый случай 8: 0");
//        System.out.println("Вводим: equalNum(0)");
//        System.out.println("Ожидаемый результат: true");
//        System.out.println("Фактический результат: " + equalNum(0));
//
//        // Тест 9: 10000
//        System.out.println("\nТестовый случай 9: 10000");
//        System.out.println("Вводим: equalNum(Тест 8: 10000)");
//        System.out.println("Ожидаемый результат: false");
//        System.out.println("Фактический результат: " + equalNum(10000));
//
//        // Тест 9: 10000
//        System.out.println("\nТестовый случай 8: Тест 8: 10000");
//        System.out.println("Вводим: equalNum(Тест 8: 10000)");
//        System.out.println("Ожидаемый результат: false");
//        System.out.println("Фактический результат: " + equalNum(10000));

//        //задание 7
//// Тестирование функции square
//        System.out.println("Тестирование функции square");
//
//// Тест 1: минимальный размер (x = 1)
//        System.out.println("\nТестовый случай 1: минимальный размер");
//        System.out.println("Вводим: square(1)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("*");
//        System.out.print("Фактический результат: \n");
//        square(1);
//
//// Тест 2: базовый случай (x = 2)
//        System.out.println("\n\nТестовый случай 2: базовый случай");
//        System.out.println("Вводим: square(2)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("**");
//        System.out.println("**");
//        System.out.print("Фактический результат: \n");
//        square(2);
//
//// Тест 3: средний размер (x = 3)
//        System.out.println("\n\nТестовый случай 3: средний размер");
//        System.out.println("Вводим: square(3)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("***");
//        System.out.println("***");
//        System.out.println("***");
//        System.out.print("Фактический результат: \n");
//        square(3);
//
//// Тест 4: увеличенный размер (x = 4)
//        System.out.println("\n\nТестовый случай 4: увеличенный размер");
//        System.out.println("Вводим: square(4)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("****");
//        System.out.println("****");
//        System.out.println("****");
//        System.out.println("****");
//        System.out.print("Фактический результат: \n");
//        square(4);
//
//// Тест 5: большой размер (x = 5)
//        System.out.println("\n\nТестовый случай 5: большой размер");
//        System.out.println("Вводим: square(5)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("*****");
//        System.out.println("*****");
//        System.out.println("*****");
//        System.out.println("*****");
//        System.out.println("*****");
//        System.out.print("Фактический результат: \n");
//        square(5);
//
//// Тест 6: проверка граничного значения (x = 0)
//        System.out.println("\n\nТестовый случай 6: проверка граничного значения");
//        System.out.println("Вводим: square(0)");
//        System.out.println("Ожидаемый результат: пустая строка");
//        System.out.print("Фактический результат: \n");
//        square(0);
//
//// Тест 7: проверка отрицательного значения (x = -1)
//        System.out.println("\n\nТестовый случай 7: проверка отрицательного значения");
//        System.out.println("Вводим: square(-1)");
//        System.out.println("Ожидаемый результат: пустая строка");
//        System.out.print("Фактический результат: \n");
//        square(-1);
//        // Тестирование функции leftTriangle
//        System.out.println("Тестирование функции leftTriangle");
//
//// Тест 1: минимальный случай (x = 1)
//        System.out.println("\nТестовый случай 1: минимальный случай");
//        System.out.println("Вводим: leftTriangle(1)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("*");
//        System.out.print("Фактический результат: \n");
//        leftTriangle(1);
//
//// Тест 2: базовый случай (x = 2)
//        System.out.println("\nТестовый случай 2: базовый случай");
//        System.out.println("Вводим: leftTriangle(2)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("*");
//        System.out.println("**");
//        System.out.print("Фактический результат: \n");
//        leftTriangle(2);
//
//// Тест 3: средний случай (x = 4)
//        System.out.println("\nТестовый случай 3: средний случай");
//        System.out.println("Вводим: leftTriangle(4)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("*");
//        System.out.println("**");
//        System.out.println("***");
//        System.out.println("****");
//        System.out.print("Фактический результат: \n");
//        leftTriangle(4);
//
//// Тест 4: большой треугольник (x = 6)
//        System.out.println("\nТестовый случай 4: большой треугольник");
//        System.out.println("Вводим: leftTriangle(6)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("*");
//        System.out.println("**");
//        System.out.println("***");
//        System.out.println("****");
//        System.out.println("*****");
//        System.out.println("******");
//        System.out.print("Фактический результат: \n");
//        leftTriangle(6);
//
//// Тест 5: граничное значение (x = 0)
//        System.out.println("\nТестовый случай 5: граничное значение");
//        System.out.println("Вводим: leftTriangle(0)");
//        System.out.println("Ожидаемый результат: пустой вывод");
//        System.out.print("Фактический результат: \n");
//        leftTriangle(0);
//
//// Тест 6: отрицательное значение (x = -3)
//        System.out.println("\nТестовый случай 6: отрицательное значение");
//        System.out.println("Вводим: leftTriangle(-3)");
//        System.out.println("Ожидаемый результат: пустой вывод");
//        System.out.print("Фактический результат: \n");
//        leftTriangle(-3);
//
//// Тест 7: проверка на максимальное значение
//        System.out.println("\nТестовый случай 7: максимальное значение");
//        System.out.println("Вводим: leftTriangle(10)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("*");
//        System.out.println("**");
//        System.out.println("***");
//        System.out.println("****");
//        System.out.println("*****");
//        System.out.println("******");
//        System.out.println("*******");
//        System.out.println("********");
//        System.out.println("*********");
//        System.out.println("**********");
//        System.out.print("Фактический результат: \n");
//        leftTriangle(10);
//        //задание 9
//// Тестирование функции rightTriangle
//        System.out.println("Тестирование функции rightTriangle");
//
//        // Тест 1: базовый случай x = 3
//        System.out.println("\nТестовый случай 1: базовый случай x = 3");
//        System.out.println("Вводим: rightTriangle(3)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("  *");
//        System.out.println(" **");
//        System.out.println("***");
//        System.out.print("Фактический результат: \n");
//        rightTriangle(3);
//
//        // Тест 2: базовый случай x = 4
//        System.out.println("\nТестовый случай 2: базовый случай x = 4");
//        System.out.println("Вводим: rightTriangle(4)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("   *");
//        System.out.println("  **");
//        System.out.println(" ***");
//        System.out.println("****");
//        System.out.print("Фактический результат: \n");
//        rightTriangle(4);
//
//        // Тест 3: минимальный допустимый случай x = 1
//        System.out.println("\nТестовый случай 3: минимальный случай x = 1");
//        System.out.println("Вводим: rightTriangle(1)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("*");
//        System.out.print("Фактический результат: \n");
//        rightTriangle(1);
//
//        // Тест 4: случай x = 5
//        System.out.println("\nТестовый случай 4: случай x = 5");
//        System.out.println("Вводим: rightTriangle(5)");
//        System.out.println("Ожидаемый результат:");
//        System.out.println("    *");
//        System.out.println("   **");
//        System.out.println("  ***");
//        System.out.println(" ****");
//        System.out.println("*****");
//        System.out.print("Фактический результат: \n");
//        rightTriangle(5);
//
//        // Тест 5: проверка на отрицательное число
//        System.out.println("\nТестовый случай 5: проверка на отрицательное число x = -2");
//        System.out.println("Вводим: rightTriangle(-2)");
//        System.out.println("Ожидаемый результат: сообщение об ошибке");
//        System.out.print("Фактический результат: \n");
//        rightTriangle(-2);
//
//        // Тест 6: проверка на ноль
//        System.out.println("\nТестовый случай 6: проверка на ноль x = 0");
//        System.out.println("Вводим: rightTriangle(0)");
//        System.out.println("Ожидаемый результат: сообщение об ошибке");
//        System.out.print("Фактический результат: \n");
//        rightTriangle(0);
        //задание 10
        guessGame();
    }

    public static void guessGame() {
        int randomNum = 3;  // Загаданное число
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int attempts = 0;   // Счетчик попыток

        // Бесконечный цикл, как просили
        while (true) {
            System.out.println("What number am I thinking (0 to 9)? :");
            int x = sc.nextInt();
            // считаем попыточки
            attempts++;

            if (x != randomNum) {
                System.out.println("No, try again");
            } else {
                System.out.println("Yes, it's " + randomNum);
                System.out.println("You guessed it in " + attempts + " attempts!");
                // "вылетаем" из цикла при правильном ответе
                break;
            }
        }
    }
    public static void guessGame2() {
        int randomNum = 3;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("What number am I thinking (0 to 9)? :");
        int x = sc.nextInt();
        if (x != randomNum) {
            System.out.println("No, try again");
        } else {
            System.out.println("Yes, it`s " + randomNum);
        }
    }

    public static void rightTriangle(int x) {
        // Внешний цикл по строкам
        for (int i = 1; i <= x; i++) {
            // цикл с ифом, не читабально, но мне понятно
            // не знаю как это нормально объяснить
            // ставим пробел пока не отсчитаем до символа = номеру строк в обратном порядке
            // как хотите так понимайте :D
            // главное работает!
            for (int j = x; j > 0; j--) {
                if(j>i){System.out.print(" ");}
                else {System.out.print("*");}
            }
//          //альтернативный вариант
//             for (int j = 1; j <= x; j++) {
//                  if(x-j>=i){System.out.print(" ");}
//                  else {System.out.print("*");}
//              }
            // Переходим на новую строку
            System.out.println();
        }
    }



    public static void leftTriangle(int x) {
        // Внешний цикл перебирает строки
        for (int i = 1; i <= x; i++) {
            // здесь условия цикла построены таким образом
            // что в строке столько символов, скольким равна i
            // i = 2 - значит будет 2 символа. 3 - 3  . И так до тех пока не вылетит верхний цикл по ограничению
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Переход на новую строку после каждой итерации внешнего цикла
            System.out.println();
        }
    }

    public static void square(int x) {
        // Внешний цикл отвечает за количество строк с символами
        for (int i = 0; i < x; i++) {
            // Внутренний цикл отвечает за количество символов в строке
            for (int j = 0; j < x; j++) {
                // Выводим символ без перехода на новую строку
                System.out.print("*");
            }
            // После каждой строки переходим на новую
            System.out.println();
        }
    }

    public static boolean equalNum(int x) {

        // Работаем с абсолютным значением числа, чтобы избежать проблем с отрицательными числами
        x = Math.abs(x);
        // Получаем первую цифру числа
        int firstDigit = x % 10;

        //цикл по всем цифрам, включая 0 (для него сделал do)
        do {
            if (x%10 != firstDigit) return false;
            x /= 10;
        }
        while (x > 0);

        //если цикл не отвалился раньше, значит все цифры одинаковые
        return true;
    }

    public static int numLen(long x) {

        int count = 0;
        //поставил do вперёд что бы 0 корректно отрабатывал
        do {x /= 10; count++; }
        while (x > 0);
        return count;
    }

    public static int pow(int x, int y) {
        int result = 1;
        // не самый оптимальный способ, но в части задания сгодится
        // Умножаем результат сам на себя, столько раз - сколько равно y
        for (int i = 0; i < y; i++) {result *= x; }
        return result;
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
