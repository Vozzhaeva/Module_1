package com.epam.anastasiia_vozzhaeva.lesson2.task2.recipes;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Ingredient;
import com.epam.anastasiia_vozzhaeva.lesson3.EmptyIngredientException;

import java.util.concurrent.TimeUnit;

public interface Recipe {
    Ingredient[] getIngredients();

    void cook() throws InterruptedException;

    default void salt() throws InterruptedException {
        System.out.println("Солим. Перчим...");
        TimeUnit.SECONDS.sleep(1);
    }

    default double countCalories() {
        double calories = 0;
        for (Ingredient ingredient : getIngredients()) {
            calories += (double) (ingredient.getQuantity()) * (double) (ingredient.getCaloriesPerMeasure()) / 100;
        }
        return calories;
    }

    default void checkIngredientsNotNull(Ingredient[] ingredients) throws EmptyIngredientException {
        for (Ingredient ingredient : ingredients) {
            if (ingredient == null) {
                throw new EmptyIngredientException("Все ингредиенты должны быть определены!");
            }
        }
    }
}
