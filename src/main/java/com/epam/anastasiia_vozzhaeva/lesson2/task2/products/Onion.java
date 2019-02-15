package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class Onion extends Vegetable {
    public Onion(int quantity) {
        super("Лук", 40, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, чистим, режем лук...");
        TimeUnit.SECONDS.sleep(1);
    }
}
