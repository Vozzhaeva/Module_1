package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;

public abstract class Vegetable extends Ingredient {
    public Vegetable(String name, int calories, int quantity) throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        super(name, calories, quantity, Measure.GRAMME);
    }
}
