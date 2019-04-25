package com.epam.anastasiia_vozzhaeva.lesson5.task2;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiskAnalyzerTest {
    File directory = new File("C:\\TestFolder");

    File fileWith2S = new File("C:\\TestFolder\\FileWith2'ss'.txt");
    File fileWith3S = new File("C:\\TestFolder\\FileWith3'sss'.txt");
    File fileWith4S = new File("C:\\TestFolder\\TestSubFolder1\\FileWith4'ssss'.txt");
    File fileWith5S = new File("C:\\TestFolder\\TestSubFolder1\\TestSubFolder11\\FileWith4'ssss'.txt");
    File fileWithMaxS = new File("C:\\TestFolder\\TestSubFolder2\\FileWithMax'sssssss'.txt");

    File fileMaxSize1 = new File("C:\\TestFolder\\TestSubFolder1\\FileMaxSize1.txt");
    File fileMaxSize2 = new File("C:\\TestFolder\\TestSubFolder1\\FileMaxSize2.txt");
    File fileMaxSize3 = new File("C:\\TestFolder\\FileMaxSize3.txt");
    File fileMaxSize4 = new File("C:\\TestFolder\\TestSubFolder1\\TestSubFolder11\\FileMaxSize4.txt");
    File fileMaxSize5 = new File("C:\\TestFolder\\TestSubFolder2\\FileMaxSize5.txt");

    @Before
    public void generateFiles()  throws IOException {

        fileWith2S.getParentFile().mkdirs();
        fileWith2S.createNewFile();

        fileWith3S.getParentFile().mkdirs();
        fileWith3S.createNewFile();

        fileWith4S.getParentFile().mkdirs();
        fileWith4S.createNewFile();

        fileWith5S.getParentFile().mkdirs();
        fileWith5S.createNewFile();

        fileWithMaxS.getParentFile().mkdirs();
        fileWithMaxS.createNewFile();

        fileMaxSize1.getParentFile().mkdirs();
        fileMaxSize1.createNewFile();

        try ( FileWriter fileWriter = new FileWriter(fileMaxSize1, false)) {
              fileWriter.write("TextTextTextTextTextText");
        }

        fileMaxSize2.getParentFile().mkdirs();
        fileMaxSize2.createNewFile();

        try  (FileWriter fileWriter2 = new FileWriter(fileMaxSize2, false)){
            fileWriter2.write("TextTextTextTextText");
        }

        fileMaxSize3.getParentFile().mkdirs();
        fileMaxSize3.createNewFile();

        try (FileWriter fileWriter3 = new FileWriter(fileMaxSize3, false)){
            fileWriter3.write("TextTextText");
        }

        fileMaxSize4.getParentFile().mkdirs();
        fileMaxSize4.createNewFile();

        try (FileWriter fileWriter4 = new FileWriter(fileMaxSize4, false)) {
            fileWriter4.write("TextText");
        }

        fileMaxSize5.getParentFile().mkdirs();
        fileMaxSize5.createNewFile();

       try( FileWriter fileWriter5 = new FileWriter(fileMaxSize5, false)){
           fileWriter5.write("Text");
       }
    }

    @Test
    public void shouldFindFileMaxSInDirectory() {
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        Assert.assertEquals(fileWithMaxS, diskAnalyzer.findMaxSInDirectory(directory, null));
    }

    @Test
    public void shouldFind5MaxSizeFiles(){
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        List<File> actualResult=new ArrayList<>();
        actualResult.add(fileMaxSize1);
        actualResult.add(fileMaxSize2);
        actualResult.add(fileMaxSize3);
        actualResult.add(fileMaxSize4);
        actualResult.add(fileMaxSize5);
        Assert.assertEquals(actualResult, diskAnalyzer.find5MaxSizeFiles(directory));
    }

    @Test
    public void shouldFindAverageSize(){
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        long length = fileMaxSize1.length()+
                fileMaxSize2.length()+
                fileMaxSize3.length()+
                fileMaxSize4.length()+
                fileMaxSize5.length()+
                fileWithMaxS.length()+
                fileWith2S.length()+
                fileWith3S.length()+
                fileWith4S.length()+
                fileWith5S.length();
        Double actualResult=length/10.0;
        Assert.assertEquals(actualResult, diskAnalyzer.findAverageSize(directory));
    }

    @Test
    public void shouldFindAllFilesAndDirectories(){
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        Map<Character, Long[]> actualResult = new HashMap<>();
        Long[] expected1 = {3L, 0L};
        Long[] expected2 = {0L, 10L};

        diskAnalyzer.findAllFilesAndDirectories(directory,actualResult);
        Long[] actual1 = actualResult.get('T');
        Assert.assertArrayEquals(expected1,actual1);
        Long[] actual2 = actualResult.get('F');
        Assert.assertArrayEquals(expected2,actual2);
    }
    @After
    public void deleteDirectory ()throws IOException  {
        FileUtils.deleteDirectory(directory);
    }
}
