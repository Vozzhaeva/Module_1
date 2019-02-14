package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

public class TomatoРaste extends Ingredient {
    public TomatoРaste(int quantity) {
        super("Томатная паста", 80, quantity, Measure.GRAMME);
    }

    @Override
    public void prepare() throws InterruptedException {

    }
}
