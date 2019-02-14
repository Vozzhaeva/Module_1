package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class Meat extends Ingredient {
    public Meat(int quantity) {
        super("Говядина", 250, quantity, Measure.GRAMME);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, нарезаем мясо...");
        TimeUnit.SECONDS.sleep(1);
    }
}
