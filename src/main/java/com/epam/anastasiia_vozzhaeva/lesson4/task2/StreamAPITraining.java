package com.epam.anastasiia_vozzhaeva.lesson4.task2;

import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITraining {

    public static void main(String[] args) {
        StreamAPITraining streamAPITraining = new StreamAPITraining();
        streamAPITraining.startApplication();
    }

    private void startApplication() {
        Set<Integer> sequence = generateSequence();
        boolean random = isRandom(sequence);
        System.out.println("Random sequence " + random);
        boolean unique = isUnique(sequence);
        System.out.println("Unique sequence " + unique);
        Integer minElement = findMinElement(sequence);
        System.out.println("Minimal element: " + minElement);
        Integer penultimateElement = findMaxMinusOneElement(sequence);
        System.out.println("Penultimate element: " + penultimateElement);
        sequence = removeOdd(sequence);
    }

    private Set<Integer> generateSequence() {
        return Stream.iterate(0, n -> n + 1)
                .limit(1_000_000)
                .collect(Collectors.toSet());
    }

    private boolean isRandom(Set<Integer> sequence) {
        AtomicInteger index = new AtomicInteger(0);
        AtomicBoolean isRandom = new AtomicBoolean(false);
        sequence.forEach(e -> {
            if (!e.equals(index.get())) {
                isRandom.set(true);
            }
            int tmp = index.get() + 1;
            index.set(tmp);
        });

        return isRandom.get();
    }

    private boolean isUnique(Set<Integer> sequence) {
        long count = sequence.stream().distinct().count();
        return sequence.size() == count;
    }

    private Integer findMinElement(Set<Integer> set) {
        return set.stream()
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Cannot find min element"));
    }

    private Set<Integer> removeOdd(Set<Integer> set) {
        return set.stream().filter(e -> e % 2 == 0).collect(Collectors.toSet());
    }

    private Integer findMaxMinusOneElement(Set<Integer> set) {
        return set.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .collect(Collectors.toList())
                .get(1);
    }
}
