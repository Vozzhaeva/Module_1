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
        System.out.println("Enter operation:");
        System.out.println("+");
        System.out.println("-");
        System.out.println("*");
        System.out.println("/");
        System.out.println("0 - Exit");
    }

    private void inputOperation() {
        Scanner userInput = new Scanner(System.in);
        choiceMenu(userInput.next());
    }

    private void choiceMenu(String operation) {
        switch (operation) {
            case "+":
                add(a, b);
                break;
            case "-":
                subtract(a, b);
                break;
            case "*":
                multiply(a, b);
                break;
            case "/":
                divide(a, b);
                break;
            case "0":
                break;
            default:
                System.out.println("Enter operation: +, -, * or /.");
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