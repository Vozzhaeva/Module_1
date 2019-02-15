package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class Cabbage extends Vegetable {
    public Cabbage(int quantity) {
        super("Капуста", 25, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, шинкуем капусту...");
        TimeUnit.SECONDS.sleep(1);
    }
}
