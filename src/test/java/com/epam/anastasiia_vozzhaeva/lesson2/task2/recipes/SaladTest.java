package com.epam.anastasiia_vozzhaeva.lesson2.task2.recipes;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.*;
import com.epam.anastasiia_vozzhaeva.lesson3.EmptyIngredientException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;
import org.junit.Assert;
import org.junit.Test;

public class SaladTest {
    private Salad salad;

    @Test()
    public void shouldCountSaladCalories() throws EmptyIngredientException, WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        salad = new Salad(
                new Tomato(100),
                new Cucumber(110),
                new IcebergLettuce(220),
                new Pepper(170));

        double calories = salad.countCalories();
        Assert.assertEquals(147, calories, 1);
    }

    @Test(expected = EmptyIngredientException.class)
    public void shouldThrowExceptionOnEmptyIngredient() throws EmptyIngredientException, WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        salad = new Salad(
                null,
                new Cucumber(110),
                new IcebergLettuce(220),
                new Pepper(170));
    }

    @Test
    public void shouldSortIngredientsByCalorie() throws EmptyIngredientException, WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        Tomato tomato = new Tomato(100);
        Cucumber cucumber = new Cucumber(110);
        IcebergLettuce icebergLettuce = new IcebergLettuce(220);
        Pepper pepper = new Pepper(170);

        salad = new Salad(
                tomato,
                cucumber,
                icebergLettuce,
                pepper);

        Ingredient[] sortedArrayOfIngredients = new Ingredient[]{
                cucumber,
                tomato,
                pepper,
                icebergLettuce
        };
        salad.sortByCalories();
        Assert.assertArrayEquals(sortedArrayOfIngredients, salad.getIngredients());
    }
}
