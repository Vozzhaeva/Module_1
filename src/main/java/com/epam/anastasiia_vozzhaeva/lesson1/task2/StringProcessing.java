package com.epam.anastasiia_vozzhaeva.lesson1.task2;

import java.util.Scanner;

// Возжаева А.В. Task 2. №3 Вывести на консоль те строки, длина которых меньше средней, а также длину.
public class StringProcessing {

    private int stringsCount;                          //количество строк
    private String[] arrayOfStrings;
    private double average;                            //средняя длина строки

    public static void main(String[] args) {
        StringProcessing stringProcessing = new StringProcessing();
        stringProcessing.startApplication();
    }

    private void startApplication() {
        System.out.println("Enter the number of strings.");
        inputStringsCount();                                                  //ввод количества строк (положительное целое число)
        inputStrings();                                                       //ввод строк
        average = countAverage(arrayOfStrings);                               //подсчет средней длины строки
        System.out.println("Average string length: " + average);
        showResult();                                                         //вывод строк, длина которых меньше средней, и их длины
    }

    private void inputStringsCount() {
        Scanner sc = new Scanner(System.in);
        do {
            while (!sc.hasNextInt()) {
                System.out.println("The number must be integer and positive.");
                sc.next();
            }
            stringsCount = sc.nextInt();
        } while (stringsCount <= 0);
        arrayOfStrings = new String[stringsCount];
    }

    private void inputStrings() {
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < arrayOfStrings.length; i++) {
            System.out.println("Enter the string №" + (i + 1));
            arrayOfStrings[i] = sc2.nextLine();
        }
    }

    private int countAverage(String[] strings) {
        int length = 0;    //общая длина строк

        //подсчет общей длины всех строк
        for (String string : strings) {
            length += string.length();
        }

        //возвращаем среднюю длину всех строк
        return length / strings.length;
    }

    private void showResult() {
        for (int i = 0; i < stringsCount; i++) {
            if (arrayOfStrings[i].length() < average) {
                System.out.printf("String: %s \tLength: %d\n", arrayOfStrings[i], arrayOfStrings[i].length());
            }
        }
    }
}
