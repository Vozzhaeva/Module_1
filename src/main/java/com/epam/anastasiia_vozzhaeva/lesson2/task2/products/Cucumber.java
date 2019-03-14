package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;

import java.util.concurrent.TimeUnit;

public class Cucumber extends Vegetable {
    public Cucumber(int quantity) throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        super("Огурец", 14, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, нарезаем огурцы...");
        TimeUnit.SECONDS.sleep(1);
    }
}

