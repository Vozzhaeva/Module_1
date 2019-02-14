package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import java.util.concurrent.TimeUnit;

public class IcebergLettuce extends Vegetable {
    public IcebergLettuce(int quantity) {
        super("Салат Айсберг", 27, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, нарезаем листья салата...");
        TimeUnit.SECONDS.sleep(1);
    }

}
