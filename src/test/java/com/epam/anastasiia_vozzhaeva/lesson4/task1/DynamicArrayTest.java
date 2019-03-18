package com.epam.anastasiia_vozzhaeva.lesson4.task1;

import org.junit.Assert;
import org.junit.Test;

public class DynamicArrayTest {

    @Test
    public void shouldAddElements() {
        String testString1 = "Test 1";
        String testString2 = "Test 2";
        String testString3 = "Test 3";
        String testString4 = "Test 4";
        String testString5 = "Test 5";

        DynamicArray dynamicArray = new DynamicArray(4);
        dynamicArray.add(testString1);
        dynamicArray.add(testString2);
        dynamicArray.add(testString3);
        dynamicArray.add(testString4);
        dynamicArray.add(testString5);

        Assert.assertEquals(5, dynamicArray.size());
        Assert.assertEquals(testString1, dynamicArray.get(0));
        Assert.assertEquals(testString2, dynamicArray.get(1));
        Assert.assertEquals(testString3, dynamicArray.get(2));
        Assert.assertEquals(testString4, dynamicArray.get(3));
        Assert.assertEquals(testString5, dynamicArray.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOutOfBoundsException() {

        DynamicArray dynamicArray = new DynamicArray(4);
        dynamicArray.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOutOfBoundsException2() {

        String testString1 = "Test 1";
        String testString2 = "Test 2";

        DynamicArray dynamicArray = new DynamicArray(2);
        dynamicArray.add(testString1);
        dynamicArray.add(testString2);

        dynamicArray.get(2);

    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldRemoveElement() {

        String testString1 = "Test 1";
        String testString2 = "Test 2";

        DynamicArray dynamicArray = new DynamicArray(2);
        dynamicArray.add(testString1);
        dynamicArray.add(testString2);

        dynamicArray.remove(1);
        dynamicArray.get(1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionOnRemoveNonExistElement() {

        String testString1 = "Test 1";
        String testString2 = "Test 2";

        DynamicArray dynamicArray = new DynamicArray(2);
        dynamicArray.add(testString1);
        dynamicArray.add(testString2);

        dynamicArray.remove(2);

    }
}
