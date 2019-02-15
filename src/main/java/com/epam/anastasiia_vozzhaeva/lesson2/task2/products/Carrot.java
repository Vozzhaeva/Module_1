package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class Carrot extends Vegetable {
    public Carrot(int quantity) {
        super("Морковь", 32, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, чистим, режем морковь...");
        TimeUnit.SECONDS.sleep(1);
    }
}
