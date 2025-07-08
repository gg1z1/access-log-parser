package com.stepup.alp;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        for (int i = 0; i <= 5;i++ ) {
            System.out.println("Введите первое число: ");
            int firstNumber = new Scanner(System.in).nextInt();
            System.out.println("Введите второе число: ");
            int secondNumber = new Scanner(System.in).nextInt();

            //сумма
            int intResult = firstNumber + secondNumber;
            System.out.println("Результат сложения чисел (сумма): " + intResult);

            //разность
            intResult = firstNumber - secondNumber;
            System.out.println("Результат вычитания чисел (разность): " + intResult);

            //произведение
            intResult = firstNumber * secondNumber;
            System.out.println("Результат умножение чисел (произведение): " + intResult);

            //частное
            double doubleResult = (double) firstNumber / secondNumber;
            System.out.println("Результат деления чисел (частное): " + doubleResult);

            System.out.println("Расчет закончен!");
        }
    }
}
