package com.epam.anastasiia_vozzhaeva.lesson3;

public final class WrongQuantityException extends IngredientException {

    public WrongQuantityException() {
        super("Неверное количество продукта");
    }
}