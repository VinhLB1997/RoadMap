package com.java.roadmap.java8;

import java.util.Arrays;
import java.util.Random;

public class ParallelArraySort {
    public static void main(String[] args) {
        int size = 100000000;
        int[] arr1 = initArrayRandom(size);
        int[] arr2 = arr1.clone();

        long startTime = System.nanoTime();
        Arrays.sort(arr1);
        long endTime = System.nanoTime();
        long duration1 = (endTime - startTime);
        System.out.println("Normal sort duration: " + duration1 + " nanoseconds");

        startTime = System.nanoTime();
        Arrays.parallelSort(arr2);
        endTime = System.nanoTime();
        long duration2 = (endTime - startTime);
        System.out.println("Parallel sort duration: " + duration2 + " nanoseconds");

        System.out.println("Parallel sort is " + (duration1 / duration2 * 1.0) + " times faster than normal sort");
    }

    private static int[] initArrayRandom(int size){
        int[] arrays = new int[size];
        Random random = new Random();
        for(int i = 0; i < size; i++){
            arrays[i] = random.nextInt(1000);
        }
        return arrays;
    }
}
