package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

public class Vinegar extends Ingredient {
    public Vinegar(int quantity) {
        super("Уксус", 18, quantity, Measure.MILLILITER);
    }

    @Override
    public void prepare() throws InterruptedException {

    }
}
