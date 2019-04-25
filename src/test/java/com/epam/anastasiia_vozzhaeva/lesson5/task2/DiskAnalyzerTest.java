package com.epam.anastasiia_vozzhaeva.lesson5.task2;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiskAnalyzerTest {
    private File directory = getFile("TestFolder");
    private File fileWith2S = getFile("TestFolder/FileWith2'ss'.txt");
    private File fileWith3S = getFile("TestFolder/FileWith3'sss'.txt");
    private File fileWith4S = getFile("TestFolder/TestSubFolder1/FileWith4'ssss'.txt");
    private File fileWith5S = getFile("TestFolder/TestSubFolder1/TestSubFolder11/FileWith4'ssss'.txt");
    private File fileWithMaxS = getFile("TestFolder/TestSubFolder2/FileWithMax'sssssss'.txt");
    private File fileMaxSize1 = getFile("TestFolder/TestSubFolder1/FileMaxSize1.txt");
    private File fileMaxSize2 = getFile("TestFolder/TestSubFolder1/FileMaxSize2.txt");
    private File fileMaxSize3 = getFile("TestFolder/FileMaxSize3.txt");
    private File fileMaxSize4 = getFile("TestFolder/TestSubFolder1/TestSubFolder11/FileMaxSize4.txt");
    private File fileMaxSize5 = getFile("TestFolder/TestSubFolder2/FileMaxSize5.txt");

    @Test
    public void shouldFindFileMaxSInDirectory() {
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        Assert.assertEquals(fileWithMaxS, diskAnalyzer.findMaxSInDirectory(directory, null));
    }

    @Test
    public void shouldFind5MaxSizeFiles() {
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        List<File> actualResult = new ArrayList<>();
        actualResult.add(fileMaxSize1);
        actualResult.add(fileMaxSize2);
        actualResult.add(fileMaxSize3);
        actualResult.add(fileMaxSize4);
        actualResult.add(fileMaxSize5);
        Assert.assertEquals(actualResult, diskAnalyzer.find5MaxSizeFiles(directory));
    }

    @Test
    public void shouldFindAverageSize() {
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        Double expectedResult = 6.8;
        Assert.assertEquals(expectedResult, diskAnalyzer.findAverageSize(directory));
    }

    @Test
    public void shouldFindAllFilesAndDirectories() {
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        Map<Character, Long[]> actualResult = new HashMap<>();
        Long[] expected1 = {3L, 0L};
        Long[] expected2 = {0L, 10L};

        diskAnalyzer.findAllFilesAndDirectories(directory, actualResult);
        Long[] actual1 = actualResult.get('T');
        Assert.assertArrayEquals(expected1, actual1);
        Long[] actual2 = actualResult.get('F');
        Assert.assertArrayEquals(expected2, actual2);
    }

    private File getFile(String fileName) {
        return new File(getClass().getClassLoader().getResource(fileName).getFile());
    }
}
