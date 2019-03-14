package com.epam.anastasiia_vozzhaeva.lesson2.task2.recipes;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Ingredient;
import com.epam.anastasiia_vozzhaeva.lesson3.EmptyIngredientException;

import java.util.concurrent.TimeUnit;

public class Salad implements Recipe {
    private Ingredient[] ingredients;

    public Salad(Ingredient... ingredients) throws EmptyIngredientException {
        checkIngredientsNotNull(ingredients);
        this.ingredients = ingredients;
    }

    @Override
    public void cook() throws InterruptedException {
        System.out.println("Готовим салат...\n");
        for (Ingredient ingredient : ingredients) {
            ingredient.prepare();
        }
        salt();
        mix();
        System.out.println("Салат готов!\n");
    }

    @Override
    public Ingredient[] getIngredients() {
        return ingredients;
    }

    private void mix() throws InterruptedException {
        System.out.println("Перемешиваем салат...");
        TimeUnit.SECONDS.sleep(1);
    }

    public void sortByCalories() {
        System.out.println("Сортировка овощей салата по калорийности: ");
        for (int i = 0; i < ingredients.length; i++) {
            double minimumCalorie = (double) ingredients[i].getCaloriesPerMeasure() * ingredients[i].getQuantity() / 100;
            int ingredientIndex = i;

            for (int j = i + 1; j < ingredients.length; j++) {
                if ((double) ingredients[j].getCaloriesPerMeasure() * ingredients[j].getQuantity() / 100 < minimumCalorie) {
                    minimumCalorie = (double) ingredients[j].getCaloriesPerMeasure() * ingredients[j].getQuantity() / 100;
                    ingredientIndex = j;
                }

                if (i != ingredientIndex) {
                    Ingredient tmp = ingredients[i];
                    ingredients[i] = ingredients[ingredientIndex];
                    ingredients[ingredientIndex] = tmp;
                }
            }
        }
    }

    public void printIngredients() {
        for (Ingredient ingredient : ingredients) {
            double caloriesCount = (double) ingredient.getQuantity() * ingredient.getCaloriesPerMeasure() / 100;
            System.out.printf(
                    "%s %d %s %s Ккал.\n",
                    ingredient.getName(),
                    ingredient.getQuantity(),
                    ingredient.getMeasure().getAbbreviation(),
                    caloriesCount);
        }
        System.out.println();
    }
}
