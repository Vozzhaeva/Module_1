package com.epam.anastasiia_vozzhaeva.lesson5.task1;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Pepper;
import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.Tomato;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;

import java.io.*;

public class ObjectSerialization {
    static final String NAME = "test.txt";

    public static void main(String[] args) throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        ObjectSerialization objectSerialization = new ObjectSerialization();
        objectSerialization.startApplication();
    }

    private void startApplication() throws WrongQuantityException, IngredientNamingException, IngredientCaloriesPerMeasureException {
        Tomato tomato = new Tomato(134);
        writeObject(tomato);
        Tomato tomatoSerialized = (Tomato) readObject();
        System.out.println(tomatoSerialized);

        Pepper pepper = new Pepper(342);
        writeObject(pepper);
        Pepper pepperSerialized = (Pepper) readObject();
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

    private static Serializable readObject() {
        Serializable serializable = null;
        try (FileInputStream fis = new FileInputStream(NAME);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            serializable = (Serializable) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return serializable;
    }
}
