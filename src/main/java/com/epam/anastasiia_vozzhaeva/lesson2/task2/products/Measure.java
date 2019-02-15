package com.epam.anastasiia_vozzhaeva.lesson2.task2.products;

public enum Measure {
    GRAMME("гр."),
    MILLILITER("мл.");

    private String abbreviation;

    Measure(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
