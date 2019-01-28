package com.epam.anastasiia_vozzhaeva.lesson1.task3;

import java.util.Scanner;

// Возжаева А.В. Task 3
public class Calculator {
    private int a;
    private int b;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.startApplication();
    }

    private void startApplication() {
        System.out.println("Enter the number A:");
        a = readNumber();                               //ввод первого числа
        System.out.println("Enter the number B:");
        b = readNumber();                               //ввод второго числа
        outputMenu();                                   //вывод меню
        inputOperation();                               //ввод номера меню
    }

    private int readNumber() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("The number must be integer.");
            sc.next();
        }
        return sc.nextInt();
    }

    private void outputMenu() {
        System.out.println("Enter operation number:");
        System.out.println("1. +");
        System.out.println("2. -");
        System.out.println("3. *");
        System.out.println("4. /");
        System.out.println("0. Exit");
    }

    private void inputOperation() {
        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNextInt()) {
            System.out.println("Enter operation number: 1,2, 3 or 4.");
            userInput.next();
        }
        choiceMenu(userInput.nextInt());
    }

    private void choiceMenu(int numMenu) {
        switch (numMenu) {
            case 1:
                add(a, b);
                break;
            case 2:
                subtract(a, b);
                break;
            case 3:
                multiply(a, b);
                break;
            case 4:
                divide(a, b);
                break;
            case 0:
                break;
            default:
                System.out.println("Enter operation number: 1,2, 3 or 4.");
                inputOperation();
                break;
        }
    }

    private void add(int a, int b) {
        System.out.println("Result: \n" +
                "A = " + a + "\n" +
                "B = " + b + "\n" +
                "A + B = " + (a + b));
    }

    private void subtract(int a, int b) {
        System.out.println("Result: \n" +
                "A = " + a + "\n" +
                "B = " + b + "\n" +
                "A - B = " + (a - b));
    }

    private void multiply(int a, int b) {
        System.out.println("Result: \n" +
                "A = " + a + "\n" +
                "B = " + b + "\n" +
                "A * B = " + (a * b));
    }

    private void divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error! Can't divide by zero. Choose new operation!");
        } else {
            System.out.println("Result: \n" +
                    "A = " + a + "\n" +
                    "B = " + b + "\n" +
                    "A / B = " + (double) a / (double) b);
        }
    }
}