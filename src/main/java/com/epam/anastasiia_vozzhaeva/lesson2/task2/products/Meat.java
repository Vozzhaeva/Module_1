package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;

import java.util.concurrent.TimeUnit;

public class Meat extends Ingredient {
    public Meat(int quantity) throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        super("Говядина", 250, quantity, Measure.GRAMME);
    }

    @Override
    public void prepare() throws InterruptedException {
        System.out.println("Моем, нарезаем мясо...");
        TimeUnit.SECONDS.sleep(1);
    }
}
