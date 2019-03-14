package com.epam.anastasiia_vozzhaeva.lesson3;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Ingredient;
import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Vegetable;


public class Exceptions {
    public static void main(String[] args) {
        Exceptions exceptions = new Exceptions();
        exceptions.startApplication();
    }

    public static void startApplication() {
        testIngredientNaming("", 12, 130);
        testIngredientNaming("Морковь", -2, 190);
        testIngredientNaming("Лук", 19, -20);
        //должен упасть с NullPointerException(Unchecked exception)
        testIngredientMeasure();
    }

    private static void testIngredientMeasure() {
        try {
            new Ingredient("", 12, 12, null) {
                @Override
                public void prepare() {
                    System.out.println();
                }
            };
        } catch (IngredientNamingException e) {
            System.out.println("Произошла ошибка IngredientNamingException, сообщение об ошибке: " + e.getMessage());
        } catch (WrongQuantityException e) {
            System.out.println("Произошла ошибка WrongQuantityException, сообщение об ошибке: " + e.getMessage());
        } catch (IngredientCaloriesPerMeasureException e) {
            System.out.println("Произошла ошибка IngredientCaloriesPerMeasureException, сообщение об ошибке:" + e.getMessage());
        } finally {
            System.out.println();
        }
    }

    private static void testIngredientNaming(String ingredientName, int calories, int quantity) {
        try {
            new Vegetable(ingredientName, calories, quantity) {
                @Override
                public void prepare() {
                }
            };
        } catch (WrongQuantityException e) {
            System.out.println("Произошла ошибка WrongQuantityException, сообщение об ошибке: " + e.getMessage());
        } catch (IngredientNamingException e) {
            System.out.println("Произошла ошибка IngredientNamingException, сообщение об ошибке: " + e.getMessage());
        } catch (IngredientCaloriesPerMeasureException e) {
            System.out.println("Произошла ошибка IngredientCaloriesPerMeasureException, сообщение об ошибке: " + e.getMessage());
        } finally {
            System.out.println();
        }
    }
}

