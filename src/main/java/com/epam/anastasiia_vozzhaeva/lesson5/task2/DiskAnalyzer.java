package com.epam.anastasiia_vozzhaeva.lesson5.task2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DiskAnalyzer {

    private File path;
    private int count = 0;
    private File file;

    Map<File, Long> filesNamesAndSize = new HashMap<>();
    List<File> top5FilesMaxSize = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        DiskAnalyzer diskAnalyzer = new DiskAnalyzer();
        diskAnalyzer.startApplication();
    }

    private void startApplication() throws IOException {
        path = readPath();
        outputMenu();
        defineFunction();
    }

    private File readPath() throws IOException {
        System.out.println("Введите путь(Например C:\\Program Files\\Apache Directory Studio):");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File path = new File(bufferedReader.readLine());
        return path;
    }

    private void outputMenu() {
        System.out.println("Выберите и введите номер функции:");
        System.out.println("1. Поиск имени файла с максимальным количеством букв ‘s’ в имени, вывод пути к нему.");
        System.out.println("2. Top-5 файлов с самым большим размером");
        System.out.println("3. Средний размер файла в указанной директории или любой ее поддиректории");
        System.out.println("4. Количество файлов и папок разбитое по первым буквам алфавита (например на букву A – начинается 100 000 файлов и 200 папок)");
        System.out.println("0 - Exit");
    }

    private void defineFunction() throws IOException {
        Scanner function = new Scanner(System.in);
        switch (function.next()) {
            case "1":
                findFileNameContainMaxNumberOfS(path);
                printFileNameContainMaxNumberOfS();
                break;
            case "2":
                findTop5MaxSize(path);
                printTop5MaxSize();
                break;
            case "3":
               findAverageFileSize(path);
                break;
            case "4":
                //
                break;
            case "0":
                break;
            default:
                System.out.println("Введите номер функции: 1,2.3 или 4. Для выхода нажмите 0.");
                defineFunction();
                break;
        }
    }

    private void findFileNameContainMaxNumberOfS(File path) throws IOException {
        File[] folderEntries = path.listFiles();
        try {
            for (File entry : folderEntries) {
                if (entry.isDirectory()) {
                    findFileNameContainMaxNumberOfS(entry);
                    continue;
                }
                if (count < entry.getName().toUpperCase().split("S").length - 1) {
                    count = entry.getName().toUpperCase().split("S").length - 1;
                    file = entry;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Указан некорректный путь!");
            startApplication();
        }
    }

    private void printFileNameContainMaxNumberOfS() throws IOException {
        FileWriter writer = new FileWriter("file.txt", false);
            writer.write("Поиск имени файла с максимальным количеством букв ‘s’ в имени, вывод пути к нему: \n" +file.getName());
            writer.flush();
    }

    public void findTop5MaxSize(File path) throws IOException {
        File[] folderEntries = path.listFiles();
        try {
            for (File entry : folderEntries) {
                if (entry.isDirectory()) {
                    findTop5MaxSize(entry);
                    continue;
                }
                filesNamesAndSize.put(entry, entry.length());
            }
            top5FilesMaxSize = filesNamesAndSize.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(5).map(Map.Entry::getKey).collect(Collectors.toList());
        } catch (NullPointerException e) {
            System.out.println("Указан некорректный путь!");
            startApplication();
        }
    }

    public void printTop5MaxSize() throws IOException {
        FileWriter writer = new FileWriter("file.txt", false);
            writer.write("Top-5 файлов с самым большим размером:");
            for (File file : top5FilesMaxSize) {
                writer.write("\n");
                writer.write(file.getName());
            }
            writer.flush();
    }

    public void findAverageFileSize(File path) throws IOException{
        File[] folderEntries = path.listFiles();
        long averageFileSize=0;
        try {
            for (File entry : folderEntries) {
                if (entry.isDirectory()) {
                    findAverageFileSize(entry);
                    continue;
                }
                filesNamesAndSize.put(entry, entry.length());
            }


            averageFileSize=filesNamesAndSize.entrySet().stream().mapToInt((s) -> Integer.parseInt(s)).average();
          //  top5FilesMaxSize = filesNamesAndSize.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(5).map(Map.Entry::getKey).collect(Collectors.toList());
        } catch (NullPointerException e) {
            System.out.println("Указан некорректный путь!");
            startApplication();
        }
    }
}





