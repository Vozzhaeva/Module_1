package com.epam.anastasiia_vozzhaeva.lesson2.task2;

import com.epam.anastasiia_vozzhaeva.lesson2.task2.products.*;
import com.epam.anastasiia_vozzhaeva.lesson2.task2.recipes.Borsch;
import com.epam.anastasiia_vozzhaeva.lesson2.task2.recipes.Salad;
import com.epam.anastasiia_vozzhaeva.lesson3.EmptyIngredientException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientCaloriesPerMeasureException;
import com.epam.anastasiia_vozzhaeva.lesson3.IngredientNamingException;
import com.epam.anastasiia_vozzhaeva.lesson3.WrongQuantityException;

public class ChiefCooker {
    public static void main(String[] args) {
        ChiefCooker chiefCooker = new ChiefCooker();
        chiefCooker.startApplication();
    }

    private void startApplication() {
        Salad vegetableSalad = null;
        try {
            vegetableSalad = new Salad(
                    new Tomato(200),
                    new Cucumber(170),
                    new IcebergLettuce(300),
                    new Pepper(200));
            Borsch borsch = new Borsch(
                    new Carrot(100),
                    new Onion(100),
                    new Beet(200),
                    new Meat(500),
                    new Potato(250),
                    new Cabbage(150),
                    new Vinegar(5),
                    new TomatoРaste(100));

            vegetableSalad.cook();                                                                               //приготовить овощной салат
            borsch.cook();                                                                                       //приготовить борщ
            System.out.println("Калорийность салата - " + vegetableSalad.countCalories() + " Ккал.\n");          //посчитать и вывести калорийность салата
            System.out.println("Калорийность борща - " + borsch.countCalories() + " Ккал.\n");                   //посчитать и вывести калорийность борща
            vegetableSalad.sortByCalories();                                                                     //сортировка овощей для салата по калорийности
            vegetableSalad.printIngredients();
            borsch.findProduct(110, 120);                                                       //поиск продуктов в борще по диапазону параметров
        } catch (EmptyIngredientException e) {
            System.out.println(e.getMessage());
        } catch (WrongQuantityException e) {
            System.out.println("Произошла ошибка WrongQuantityException, сообщение об ошибке: " + e.getMessage());
        } catch (IngredientNamingException e) {
            System.out.println("Произошла ошибка IngredientNamingException, сообщение об ошибке: " + e.getMessage());
        } catch (IngredientCaloriesPerMeasureException e) {
            System.out.println("Произошла ошибка IngredientCaloriesPerMeasureException, сообщение об ошибке:" + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
