package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;

public abstract class Ingredient implements Preparable {
    private String name;
    private int caloriesPerMeasure;
    private int quantity;
    private Measure measure;

    public Ingredient(String name, int caloriesPerMeasure, int quantity, Measure measure) throws IngredientNamingException, WrongQuantityException, IngredientCaloriesPerMeasureException {
        if (name == null || measure == null) {
            throw new NullPointerException("Необходимо задать не null значения");
        }
        if (name.equals("")) {
            throw new IngredientNamingException();
        }
        if (quantity <= 0) {
            throw new WrongQuantityException();
        }
        if (caloriesPerMeasure <= 0) {
            throw new IngredientCaloriesPerMeasureException();
        }
        this.name = name;
        this.caloriesPerMeasure = caloriesPerMeasure;
        this.quantity = quantity;
        this.measure = measure;
    }

    public int getCaloriesPerMeasure() {
        return caloriesPerMeasure;
    }

    public void setCaloriesPerMeasure(int caloriesPerMeasure) {
        this.caloriesPerMeasure = caloriesPerMeasure;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}

