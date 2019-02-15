package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class Tomato extends Vegetable {
    public Tomato(int quantity) {
        super("Помидор", 23, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, нарезаем помидоры...");
        TimeUnit.SECONDS.sleep(1);
    }
}
