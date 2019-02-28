package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;

public class Vinegar extends Ingredient {
    public Vinegar(int quantity) throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        super("Уксус", 18, quantity, Measure.MILLILITER);
    }

    @Override
    public void prepare() {

    }
}
