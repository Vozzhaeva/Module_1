package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

public abstract class Ingredient implements Preparable {
    private String name;
    private int caloriesPerMeasure;
    private int quantity;
    private Measure measure;

    Ingredient(String name, int caloriesPerMeasure, int quantity, Measure measure) {
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

