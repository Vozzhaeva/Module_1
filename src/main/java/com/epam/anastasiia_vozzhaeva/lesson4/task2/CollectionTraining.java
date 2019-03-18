package com.epam.anastasiia_vozzhaeva.lesson4.task2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionTraining {

    public static void main(String[] args) {
        CollectionTraining collectionTraining = new CollectionTraining();
        collectionTraining.startApplication();
    }

    private void startApplication() {
        Set<Integer> sequence = generateSequence();
        boolean random = isRandom(sequence);
        System.out.println("Random sequence " + random);
        boolean unique = isUnique(sequence);
        System.out.println("Unique sequence " + unique);
        Integer minElement = findMinElement(sequence);
        System.out.println("Minimal element: " + minElement);
        Integer penultimate = findMaxMinusOneElement(sequence);
        System.out.println("Penultimate element: " + penultimate);
        sequence = removeOdd(sequence);
    }

    private Set<Integer> generateSequence() {
        Set<Integer> sequence = new HashSet<>();

        for (int i = 0; i < 1_000_000; i++) {
            sequence.add(i);
        }
        return sequence;
    }

    private boolean isRandom(Set<Integer> sequence) {
        Integer i = 0;
        boolean isRandom = false;
        for (Integer element : sequence) {
            if (!i.equals(element)) {
                isRandom = true;
                break;
            }
            i++;
        }
        return isRandom;
    }

    private boolean isUnique(Set<Integer> sequence) {
        Set<Integer> counter = new HashSet<>();
        for (Integer element : sequence) {
            boolean contain = counter.contains(element);
            if (contain) {
                return false;
            } else {
                counter.add(element);
            }
        }
        return true;
    }

    private Integer findMinElement(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        Integer minElement = null;
        while (iterator.hasNext()) {
            Integer nextElement = iterator.next();
            if (minElement == null || (nextElement != null && nextElement < minElement)) {
                minElement = nextElement;
            }
        }
        return minElement;
    }

    private Set<Integer> removeOdd(Set<Integer> set) {
        Set<Integer> result = new HashSet<>();
        set.forEach(e -> {
                    if (e % 2 == 0) {
                        result.add(e);
                    }
                }
        );
        return result;
    }

    private Integer findMaxMinusOneElement(Set<Integer> set) {
        Integer prevMaxElement = null;
        Integer maxElement = null;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer nextElement = iterator.next();
            if (maxElement == null) {
                maxElement = nextElement;
            } else if (prevMaxElement == null) {
                prevMaxElement = nextElement;
            } else {
                if (nextElement > maxElement) {
                    prevMaxElement = maxElement;
                    maxElement = nextElement;
                } else if (nextElement > prevMaxElement && nextElement < maxElement) {
                    prevMaxElement = nextElement;
                }
            }
        }
        return prevMaxElement;
    }
}
