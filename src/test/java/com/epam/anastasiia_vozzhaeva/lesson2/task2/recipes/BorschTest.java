package com.epam.anastasiia_vozzhaeva.lesson2.task2.recipes;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.*;
import com.epam.anastasiia_vozzhaeva.lesson3.EmptyIngredientException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;
import org.junit.Assert;
import org.junit.Test;

public class BorschTest {

    @Test
    public void shouldСountIngredientsInBorsch() throws EmptyIngredientException, WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        Borsch borsch = new Borsch(
                new Carrot(90),
                new Onion(80),
                new Beet(135),
                new Meat(390),
                new Potato(200),
                new Cabbage(140),
                new Vinegar(5),
                new TomatoРaste(90));
        Assert.assertEquals(8, borsch.getIngredients().length);
    }

    @Test
    public void shouldCountBorschCalories() throws EmptyIngredientException, WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        Borsch borsch = new Borsch(
                new Carrot(90),
                new Onion(80),
                new Beet(135),
                new Meat(390),
                new Potato(200),
                new Cabbage(140),
                new Vinegar(5),
                new TomatoРaste(90));

        double calories = borsch.countCalories();
        Assert.assertEquals(1355.75, calories, 1);
    }

    @Test(expected = EmptyIngredientException.class)
    public void shouldThrowExceptionOnEmptyIngredient() throws EmptyIngredientException, WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        new Borsch(
                null,
                new Onion(80),
                new Beet(135),
                new Meat(390),
                new Potato(200),
                new Cabbage(140),
                new Vinegar(5),
                new TomatoРaste(90));
    }
}
