package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;

import java.util.concurrent.TimeUnit;

public class Cabbage extends Vegetable {
    public Cabbage(int quantity) throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        super("Капуста", 25, quantity);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, шинкуем капусту...");
        TimeUnit.SECONDS.sleep(1);
    }
}
