package com.epam.anastasiia_vozzhaeva.lesson3;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Ingredient;
import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Vegetable;
import org.junit.Test;

public class ExceptionTest {
    @Test(expected = IngredientNamingException.class)
    public void shouldThrowIngredientNamingException() throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        new Vegetable("", 10, 120) {
            @Override
            public void prepare() {
            }
        };
    }

    @Test(expected = IngredientCaloriesPerMeasureException.class)
    public void shouldThrowIngredientCaloriesPerMeasureException() throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        new Vegetable("Перец", -2, 120) {
            @Override
            public void prepare() {
            }
        };
    }

    @Test(expected = WrongQuantityException.class)
    public void shouldThrowWrongQuantityException() throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        new Vegetable("Капуста", 15, -9) {
            @Override
            public void prepare() {
            }
        };
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionOnWrongName() throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        new Vegetable(null, 100, 100) {
            @Override
            public void prepare() {
            }
        };
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionOnWrongMeasure() throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        new Ingredient("", 120, 120, null) {
            @Override
            public void prepare() {
            }
        };
    }
}
