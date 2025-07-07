package com.stepup.alp;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Введите текст и нажмите <Enter>: ");
        String text = new Scanner(System.in).nextLine();
        System.out.println("Длинна текста: " + text.length());
    }
}
