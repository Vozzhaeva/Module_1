package com.epam.anastasiia_vozzhaeva.lesson5.task2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DiskAnalyzer {

    private File path;

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
        System.out.println("Введите путь (Например C:\\):");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            File path = new File(bufferedReader.readLine());
            if (path.isDirectory()) {
                return path;
            } else {
                System.out.println("Ошибка! Введите корректный путь:");
            }
        }
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
                printMaxSCountFile(path);
                break;
            case "2":
                print5MaxSizeFiles(path);
                break;
            case "3":
                printAverageSize(path);
                break;
            case "4":
                findCountByFirstAlphabet(path);
                break;
            case "0":
                break;
            default:
                System.out.println("Введите номер функции: 1,2.3 или 4. Для выхода нажмите 0.");
                defineFunction();
                break;
        }
    }

    private void printMaxSCountFile(File directory) throws IOException {
        File terminateFilesByFilter = findMaxSInDirectory(directory, null);
        FileWriter writer = new FileWriter("file.txt", false);
        writer.write("Поиск имени файла с максимальным количеством букв ‘s’ в имени, вывод пути к нему: \n" + terminateFilesByFilter + "\nКоличество символов 's': " + getCountOfCharS(terminateFilesByFilter));
        writer.flush();
        System.out.println("Результат успешно записан в файл file.txt");
    }

    private File findMaxSInDirectory(File directory, File withMaxSCount) {
        File[] files = directory.listFiles();
        if (files!=null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    withMaxSCount = findMaxSInDirectory(file, withMaxSCount);
                } else {
                    Long countOfCharS = getCountOfCharS(file);
                    if (countOfCharS > 0) {
                        if (withMaxSCount == null) {
                            withMaxSCount = file;
                        } else {
                            Long currentMax = getCountOfCharS(withMaxSCount);
                            if (currentMax < countOfCharS) {
                                withMaxSCount = file;
                            }
                        }
                    }
                }
            }
        }
        return withMaxSCount;
    }

    private static Long getCountOfCharS(File file) {
        return file.getName().chars().filter(ch -> ch == 's' || ch == 'S').count();
    }

    private void print5MaxSizeFiles(File directory) throws IOException {
        ArrayList<File> files = new ArrayList<>();
        findAllFilesByDirectory(directory, files);
        List<File> filteredFiles = files.stream()
                .sorted(
                        (item1, item2) -> Long.compare(item2.length(), item1.length())
                ).limit(5).collect(Collectors.toList());

        FileWriter writer = new FileWriter("file.txt", false);
        writer.write("Top-5 файлов с самым большим размером:");
        for (File file : filteredFiles) {
            writer.write("\n");
            writer.write(file.getName() + " Размер: " + file.length());
        }
        writer.flush();
        System.out.println("Результат успешно записан в файл file.txt");
    }


    private List<File> findAllFilesByDirectory(File directory, List<File> files) {
        if (directory.isDirectory()) {
            File[] fileList = directory.listFiles();
            if (fileList!=null) {
                for (File file : fileList) {
                    if (file.isDirectory()) {
                        findAllFilesByDirectory(file, files);
                    } else {
                        if (!file.isHidden()) {
                            files.add(file);
                        }
                    }
                }
            }
        }
        return files;
    }

    private void printAverageSize(File directory) throws IOException {
        ArrayList<File> files = new ArrayList<>();
        findAllFilesByDirectory(directory, files);
        OptionalDouble average = files.stream()
                .mapToLong(File::length)
                .average();
        double asDouble = average.getAsDouble();
        FileWriter writer = new FileWriter("file.txt", false);
        writer.write("Средний размер файла в указанной директории и  любой ее поддиректории: " + asDouble);
        writer.flush();
        System.out.println("Результат успешно записан в файл file.txt");
    }

    private static void findCountByFirstAlphabet(File directory) throws IOException {
        Map<Character, Long[]> resultMap = new HashMap<>();
        findAllFilesAndDirectories(directory, resultMap);
        FileWriter writer = new FileWriter("file.txt", false);
        writer.write("Top-5 файлов с самым большим размером:");
        for (Map.Entry<Character, Long[]> entry : resultMap.entrySet()) {
            Character character = entry.getKey();
            Long[] longs = entry.getValue();
            writer.write("\n");
            writer.write(" На символ - " + character + " начинается: папок " + longs[0] + ", файлов- " + longs[1]);
            writer.flush();
        }
        System.out.println("Результат успешно записан в файл file.txt");
    }

    private static void findAllFilesAndDirectories(File directory, Map<Character, Long[]> files) {
        if (directory.isDirectory()) {
            File[] fileList = directory.listFiles();
            if (fileList!=null) {
                for (File file : fileList) {
                    Character firstChar = file.getName().charAt(0);
                    Long[] defaultValue = {0L, 0L};
                    Long[] counters = files.getOrDefault(firstChar, defaultValue);
                    if (file.isDirectory()) {
                        counters[0] += 1;
                    } else {
                        counters[1] += 1;
                    }
                    files.put(firstChar, counters);
                    if (file.isDirectory()) {
                        findAllFilesAndDirectories(file, files);
                    }
                }
            }
        }
    }
}





