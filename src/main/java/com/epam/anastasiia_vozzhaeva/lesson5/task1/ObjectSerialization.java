package com.epam.anastasiia_vozzhaeva.lesson5.task1;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Pepper;
import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Tomato;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;

import java.io.*;
import java.util.Optional;

public class ObjectSerialization {
    static final String NAME = "test.txt";

    public static void main(String[] args) throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        ObjectSerialization objectSerialization = new ObjectSerialization();
        objectSerialization.startApplication();
    }

    private void startApplication() throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {

        Tomato tomato = new Tomato(134);
        writeObject(tomato);
        Optional<Tomato> tomatoSerialized = readObject();
        System.out.println(tomatoSerialized);

        Pepper pepper = new Pepper(342);
        writeObject(pepper);
        Optional<Pepper> pepperSerialized = readObject();
        System.out.println(pepperSerialized);
    }

    private static void writeObject(Serializable objectToSerialize) {
        try (FileOutputStream fos = new FileOutputStream(NAME);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(objectToSerialize);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static <T extends Serializable> Optional<T> readObject() {
        try (FileInputStream fis = new FileInputStream(NAME);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            return Optional.ofNullable((T) in.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }
}
