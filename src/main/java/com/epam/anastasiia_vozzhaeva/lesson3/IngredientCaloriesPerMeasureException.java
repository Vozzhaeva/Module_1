package com.epam.anastasiia_vozzhaeva.lesson3;

public final class IngredientCaloriesPerMeasureException extends IngredientException {

    public IngredientCaloriesPerMeasureException() {
        super("Некорректное количество калорий продукта");
    }
}