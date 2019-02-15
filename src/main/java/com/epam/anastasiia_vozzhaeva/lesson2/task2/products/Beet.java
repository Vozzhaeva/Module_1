package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class Beet extends Vegetable {
    public Beet(int quantity) {
        super("Свекла", 43, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, чистим, режем свеклу...");
        TimeUnit.SECONDS.sleep(1);
    }
}
