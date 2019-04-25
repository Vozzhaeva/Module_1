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
        writeObject(tomato, NAME);
        Optional<Tomato> tomatoSerialized = readObject(NAME);
        System.out.println(tomatoSerialized);

        Pepper pepper = new Pepper(342);
        writeObject(pepper, NAME);
        Optional<Pepper> pepperSerialized = readObject(NAME);
        System.out.println(pepperSerialized);
    }

    public static void writeObject(Serializable objectToSerialize, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(objectToSerialize);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static <T extends Serializable> Optional<T> readObject(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            return Optional.ofNullable((T) in.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }
}
