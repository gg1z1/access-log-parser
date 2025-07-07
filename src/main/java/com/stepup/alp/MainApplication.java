package com.stepup.alp;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        for (int i = 0; i <= 5;i++ ) {
            System.out.println("Введите число: ");
            int firstNumber = new Scanner(System.in).nextInt();
            int secondNumber = new Scanner(System.in).nextInt();
            double result = (double) firstNumber / secondNumber;
            System.out.println("Результат деления чисел: " + result);
        }
    }
}
