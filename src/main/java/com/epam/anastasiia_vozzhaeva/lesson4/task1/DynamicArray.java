package com.epam.anastasiia_vozzhaeva.lesson4.task1;

import java.util.Arrays;

public class DynamicArray {
    private String[] array;
    private int size = 0;

    public DynamicArray(int n) {
        this.array = new String[n];
    }

    public void add(String string) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, 2 * array.length + 1);
        }
        array[size] = string;
        size++;
    }

    public String get(int n) {
        if (n < size) {
            return array[n];
        }
        throw new IndexOutOfBoundsException();
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public void remove(int index) {
        if (index < size) {
            String[] newArray = new String[array.length];
            for (int i = 0; i < array.length; i++) {
                if (i < index) {
                    newArray[i] = array[i];
                } else if (i > index) {
                    newArray[i - 1] = array[i];
                }
            }
            array = newArray;
            this.size--;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public int size() {
        return size;
    }
}
