package com.epam.anastasiia_vozzhaeva.lesson1.task1;

//Возжаева А.В. Task 1. №4 В массиве целых чисел утроить каждый положительный элемент, который стоит перед отрицательным.
public class ArrayProcessing {

    public static void main(String[] args) {
        ArrayProcessing arrayProcessing = new ArrayProcessing();
        arrayProcessing.startApplication();
    }

    private void startApplication() {
        int[] array = generateArray();
        printArray(array, "Input array: ");           //вывод исходного массива
        arrayAction(array);
        printArray(array, "Output array: ");          // обработка массива и вывод результата на экран
    }

    private int[] generateArray() {
        int[] array = new int[20];

        //заполнение массива
        for (int i = 0; i < array.length; i++) {
            array[i] = -10 + (int) (Math.random() * 20);       //генерация целых чисел от -10 до 10
        }
        return array;
    }

    private void printArray(int[] array, String message) {
        System.out.print(message);
        for (int arrayElement : array) {
            System.out.print(arrayElement + " ");
        }
        System.out.println();
    }

    private void arrayAction(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if ((array[i] > 0) && (array[i + 1] < 0)) {
                array[i] = array[i] * 3;
            }
        }
    }
}
