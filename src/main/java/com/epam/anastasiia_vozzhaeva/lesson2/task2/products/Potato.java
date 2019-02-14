package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class Potato extends Vegetable {
    public Potato(int quantity) {
        super("Картофель", 77, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, нарезаем картофель...");
        TimeUnit.SECONDS.sleep(1);
    }
}
