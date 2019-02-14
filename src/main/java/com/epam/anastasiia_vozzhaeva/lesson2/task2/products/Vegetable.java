package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

public abstract class Vegetable extends Ingredient {
    public Vegetable(String name, int calories, int quantity) {
        super(name, calories, quantity, Measure.GRAMME);
    }
}
