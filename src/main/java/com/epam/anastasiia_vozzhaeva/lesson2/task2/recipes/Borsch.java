package com.epam.anastasiia_vozzhaeva.lesson2.task2.recipes;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.*;

import java.util.concurrent.TimeUnit;

public class Borsch implements Recipe {
    private Ingredient[] ingredients;
    private Ingredient[] roastingIngredients;

    public Borsch(Carrot carrot, Onion onion, Beet beet, Meat meat, Potato potato, Cabbage cabbage, Vinegar vinegar, TomatoРaste tomatoPaste) throws EmptyIngredientException {
        this.ingredients = new Ingredient[]{carrot, onion, beet, meat, potato, cabbage, vinegar, tomatoPaste};
        checkIngredientsNotNull(ingredients);
        roastingIngredients = new Ingredient[]{carrot, onion, beet, vinegar, tomatoPaste};
    }

    @Override
    public void cook() throws InterruptedException {
        System.out.println("Готовим борщ...\n");
        for (Ingredient ingredient : ingredients) {
            ingredient.prepare();
        }
        System.out.println();
        fryVegetables();
        mixAndBoil();
        salt();
        System.out.println("Борщ готов!\n");
    }

    public void findProduct(int calories, int quantity) {
        System.out.println("Продукты для борща, у которых калорийность < " + calories + " Ккал. и количество < " + quantity + ":");
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getQuantity() < quantity && (ingredient.getCaloriesPerMeasure() < calories)) {
                System.out.println(ingredient.getName() + " " +
                        ingredient.getQuantity() + " " +
                        ingredient.getMeasure().getAbbreviation() + " " +
                        ingredient.getCaloriesPerMeasure() + " Ккал. на 100 " + ingredient.getMeasure().getAbbreviation());
            }
        }
    }

    @Override
    public Ingredient[] getIngredients() {
        return ingredients;
    }

    private void mixAndBoil() {
        System.out.println("Смешиваем все ингридиенты и варим 30 минут...");
    }

    private void fryVegetables() throws InterruptedException {
        System.out.println("Готовим зажарку...");
        for (Ingredient ingredient : roastingIngredients) {
            System.out.println("Добавляем " + ingredient.getName() + " в зажарку....");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Жарим 10 минут.");
        System.out.println("Зажарка готова.\n");
    }


}
