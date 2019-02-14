package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class Pepper extends Vegetable {
    public Pepper(int quantity) {
        super("Сладкий перец", 29, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, нарезаем перец...");
        TimeUnit.SECONDS.sleep(1);
    }
}
