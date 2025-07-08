package com.stepup.alp;

import java.math.RoundingMode;
import java.math.BigDecimal;

public class MainApplication {
    public static void main(String[] args) {
//        //#Задание 1 #Дробная часть.
//        System.out.println("Вводим: " + "5.35964464654654668");
//        System.out.println("Тест: " + fraction(5.35964464654654668));
//        System.out.println("Вводим: " + "0.3");
//        System.out.println("Тест: " + fraction(0.3));
//        System.out.println("Вводим: " + "108.010101010101010101");
//        System.out.println("Тест: " + fraction(108.010101010101010101));
//        System.out.println("Вводим: " + "12.3456789");
//        System.out.println("Тест: " + fraction(12.3456789));
//        System.out.println("Вводим: " + "5.3");
//        System.out.println("Тест: " + fraction(5.3));
//        System.out.println("Вводим: " + "7");
//        System.out.println("Тест: " + fraction(7));
//        System.out.println("Вводим: " + "163.0000000101001934");
//        //в некоторых случаях формат doubele переводится в эксп. нотацию
//        System.out.println("Тест: " + String.format("%.20f",fraction(163.0000000101001934)));
//        System.out.println("Вводим: " + ("-3.141592653589793"));
//        System.out.println("Тест: " + fraction(-3.141592653589793));
//        //#Задание 2 #Сумма знаков.
//        System.out.println("Вводим: " + ("25879465"));
//        System.out.println("Тест: " + sumLastNums(25879465));
//        System.out.println("Вводим: " + ("10"));
//        System.out.println("Тест: " + sumLastNums(10));
//        System.out.println("Вводим: " + ("-2567"));
//        System.out.println("Тест: " + sumLastNums(-2567));
//          //#Задание 3 #Букву в число
//        System.out.println("Вводим: " + ("0"));
//        System.out.println("Тест: " + charToNum('0'));
//        System.out.println("Вводим: " + ("1"));
//        System.out.println("Тест: " + charToNum('1'));
//        System.out.println("Вводим: " + ("2"));
//        System.out.println("Тест: " + charToNum('2'));
//        System.out.println("Вводим: " + ("9"));
//        System.out.println("Тест: " + charToNum('9'));
//          //#Задание 4 #Есть ли позитив
//        System.out.println("Вводим: " + ("-5"));
//        System.out.println("Тест: " + isPositive(-5));
//        System.out.println("Вводим: " + ("4"));
//        System.out.println("Тест: " + isPositive(4));
//        System.out.println("Вводим: " + ("100500"));
//        System.out.println("Тест: " + isPositive(100500));
//        System.out.println("Вводим: " + ("2,147,483,647"));
//        System.out.println("Тест: " + isPositive(2147483647));
//        System.out.println("Вводим: " + ("-2,147,483,648"));
//        System.out.println("Тест: " + isPositive(-2147483648));
//        System.out.println("Вводим: " + ("0"));
//        System.out.println("Тест: " + isPositive(0));
//        //#Задание 5 #Двузначное
//        System.out.println("Вводим: " + ("0"));
//        System.out.println("Тест: " + is2Digits(0));
//        System.out.println("Вводим: " + ("10"));
//        System.out.println("Тест: " + is2Digits(10));
//        System.out.println("Вводим: " + ("99"));
//        System.out.println("Тест: " + is2Digits(99));
//        System.out.println("Вводим: " + ("-10"));
//        System.out.println("Тест: " + is2Digits(-10));
//        System.out.println("Вводим: " + ("-99"));
//        System.out.println("Тест: " + is2Digits(-99));
//        System.out.println("Вводим: " + ("55"));
//        System.out.println("Тест: " + is2Digits(55));
//        System.out.println("Вводим: " + ("512"));
//        System.out.println("Тест: " + is2Digits(512));
//        //#Задание 6 #Большая буква
//        System.out.println("Вводим: " + ("X"));
//        System.out.println("Тест: " + isUpperCase('X'));
//        System.out.println("Вводим: " + ("ш"));
//        System.out.println("Тест: " + isUpperCase('ш'));
//        System.out.println("Вводим: " + ("a"));
//        System.out.println("Тест: " + isUpperCase('a'));
//        System.out.println("Вводим: " + (","));
//        System.out.println("Тест: " + isUpperCase(','));
//        System.out.println("Вводим: " + ("Б"));
//        System.out.println("Тест: " + isUpperCase('Б'));
//        System.out.println("Вводим: " + ("M"));
//        System.out.println("Тест: " + isUpperCase('M'));
//        System.out.println("Вводим: " + ("c"));
//        System.out.println("Тест: " + isUpperCase('c'));
//        System.out.println("Вводим: " + ("L"));
//        System.out.println("Тест: " + isUpperCase('L'));
//        System.out.println("Вводим: " + ("Х - русская"));
//        System.out.println("Тест: " + isUpperCase('Х'));
//        //#Задание 7 #Диапазон
//        System.out.println("Вводим: " + ("a=5 b=1 num=3"));
//        System.out.println("Тест: " + isInRange(5,1, 3));
//        System.out.println("Вводим: " + ("a=2 b=15 num=33"));
//        System.out.println("Тест: " + isInRange(2,15, 33));
//        System.out.println("Вводим: " + ("a=10 b=100 num=9"));
//        System.out.println("Тест: " + isInRange(10,100, 9));
//        System.out.println("Вводим: " + ("a=10 b=100 num=10"));
//        System.out.println("Тест: " + isInRange(10,100, 10));
//        //#Задание 8 #Делитель
//        System.out.println("Вводим: " + ("a=3 b=6"));
//        System.out.println("Тест: " + isDivisor(3,6));
//        System.out.println("Вводим: " + ("a=0 b=6"));
//        System.out.println("Тест: " + isDivisor(0,6));
//        System.out.println("Вводим: " + ("a=0 b=0"));
//        System.out.println("Тест: " + isDivisor(0,0));
//        System.out.println("Вводим: " + ("a=5 b=5"));
//        System.out.println("Тест: " + isDivisor(5,5));
//        System.out.println("Вводим: " + ("a=25 b=5"));
//        System.out.println("Тест: " + isDivisor(25,5));
//        System.out.println("Вводим: " + ("a=25 b=13"));
//        System.out.println("Тест: " + isDivisor(25,13));
//        //#Задание 9 #Равенство
//        System.out.println("Вводим: " + ("isEqual(25,5,5));"));
//        System.out.println("Тест: " + isEqual(25,5,5));
//        System.out.println("Вводим: " + ("isEqual(25,25,25));"));
//        System.out.println("Тест: " + isEqual(25,25,25));
        //#Задание 10 #Многократный вызов
        System.out.println("Вводим: " + ("lastNumSum(0, lastNumSum(1, lastNumSum(14, lastNumSum(123, lastNumSum(5,11)))));"));
        System.out.println("Тест: " + lastNumSum(0, lastNumSum(1, lastNumSum(14, lastNumSum(123, lastNumSum(5,11))))));
    }
    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }

    public static boolean isEqual(int a, int b, int c) {
        // чисто математически это корректно будет работать
        return a == b && b == c;
    }

    public static boolean isDivisor(int a, int b) {
        // код ниже универсален - рассмотрим оба случая одновеременно одной строкой
        // если делимое 0 - это false
        // если делить = 0 - это true, потому что остаток 0
        // главное что бы оба значения были не 0, в остальных случаеях всега c 1 нулём - true
        // конструкция такая (условия И условие) ИЛИ (услови И условие)
        return (a != 0 && b % a == 0) || (b != 0 && a % b == 0);
        //как альтернатива, можно было для начала определить какое больше
        //и решить что делитель, а что делимое
        // и реалезовать конкретно делителя правило деления на 0 вместо униврсального условия
        //потом менять местами и повторить операцию.
        //Выбрать один из результатов true
    }

    public static boolean isInRange(int a, int b, int num) {
        int lower,upper;
        // Определяем нижнюю границу диапазона
        lower = (b > a) ? a : b; //аналог  Math.min(a, b)
        // Определяем верхнюю границу диапазона
        upper = (b > a) ? b : a; //аналог  Math.max
        //можно и через if else, но в общем целом разницы нет
        // Проверяем, находится ли число в диапазоне [lower, upper]
        return num >= lower && num <= upper;
    }
    public static boolean isUpperCase(char x) {
        // Получаем ASCII-код символа
        int code = (int) x;

        // Проверяем, находится ли код в диапазоне {A[65], Z[90]}
        return code >= 'A' && code <= 'Z';
    }

    public static boolean is2Digits(int x) {
        // не совсем понятен кусок задания >>чтобы он принимал *положительное* число x<<
        // как я понял любое число он должен принимать, но диапазон для положительного числа
        // Проверяем, что число положительное и находится в диапазоне двузначных чисел
        // && - логическое "И", т.е. 2 условия должно совпадать >= 10 и <=99 -
        // или как вариант > 9 и < 100
       return x >= 10 && x <= 99;
    }

    public static boolean isPositive(int x) {
        //по идее 0 не считается не положительным не отрицательным
        //по этому будем считать false т.к. не положительное.
        return x > 0;
    }

    public static int charToNum(char x) {
        // Используем вычитание ASCII-кода символа '0' из переданного символа
        //код символа ‘0’ — это число 48 , остальные +1 к 48, т.е. 1 = 49, и тд.
        //т.е. результат вычитания чисел ASCII-кода - есть нужная нам цифра
        return x - '0';
    }
    public static int sumLastNums(int x) {
        // Получаем последнюю цифру
        // берём остак от 10 , это 1 цифра любого целого числа
        int lastDigit = x % 10;

        // Получаем предпоследнюю цифру
        // Делим на 10 что бы на порядок уменьшить - т.е. предидущюю последнюю цифру
        // ну и снова берём осток от 10
        int secondLastDigit = (x / 10) % 10;

        // Возвращаем сумму последних двух цифр
        return lastDigit + secondLastDigit;
    }

    public static double fraction(double x)
    {
        //возможно лишнее в рамках данного задания, но оно точно выводит число double до определённого порядка
        BigDecimal number = new BigDecimal(Double.toString(x));
        BigDecimal bdResult = number.remainder(BigDecimal.ONE);
        double doubleRestul;
        //проверка наличия точки
        String str = String.valueOf(x);
        int dotIndex = str.indexOf('.');
        if (dotIndex == -1) {
            return 0.0;
        }
        // Считаем количество значащих цифр после точки, что бы определить точность
        int scale = str.length() - dotIndex - 1;
        // Double имеет ограничения размерности, по этому вывод не всегда точен
        // По этому смотрел в строке по дебагу, что всё правильно считается
         String strResult = bdResult.setScale(scale, RoundingMode.HALF_UP).toPlainString();
        // Возвращаем результат с нужной точностью
        doubleRestul = bdResult.setScale(scale, RoundingMode.HALF_UP).doubleValue();
        return bdResult.setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }
    //вариант с вычитанием из целой части
    public static double fraction5(double x){
        double doubleNumber = Math.abs(x) ;
        int celoe = (int) (doubleNumber/1);
        double result = (double) (doubleNumber - (double) celoe);
        return result;
    }
    public static double fraction3(double x){
        return (double) (x%1);
    }
    public static double fraction2(double x){
        // Преобразуем число в строку
        String str = String.valueOf(x);

        // Находим позицию точки
        int dotIndex = str.indexOf('.');

        // Если точки нет, возвращаем 0
        if (dotIndex == -1) {
            return 0.0;
        }

        long celoe = (long) Math.pow(10, str.substring(dotIndex + 1).length()-1);
        long drobnoe = Long.valueOf(str.substring(dotIndex + 1));
        // Возвращаем часть после точки
        BigDecimal result = new BigDecimal("0." + drobnoe);
        return result.doubleValue();
    }
}


