package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class Cucumber extends Vegetable {
    public Cucumber(int quantity) {
        super("Огурец", 14, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, нарезаем огурцы...");
        TimeUnit.SECONDS.sleep(1);
    }
}

