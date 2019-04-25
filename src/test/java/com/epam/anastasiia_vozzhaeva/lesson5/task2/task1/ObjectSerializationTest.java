package com.epam.anastasiia_vozzhaeva.lesson5.task2.task1;

import com.epam.anastasiia_vozzhaeva.lesson5.task1.ObjectSerialization;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.Optional;

public class ObjectSerializationTest {
    @Test
    public void shouldAvoidExceptionWhenReadNull() {
        String fileName = "testNull.txt";
        ObjectSerialization.writeObject(null, fileName);
        Optional<Serializable> deserializedObject = ObjectSerialization.readObject(fileName);
        Assert.assertFalse(deserializedObject.isPresent());
    }
}
