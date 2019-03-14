package com.epam.anastasiia_vozzhaeva.lesson3;

public final class IngredientNamingException extends IngredientException {

    public IngredientNamingException() {
        super("Название продукта не должно быть пустым");
    }
}
