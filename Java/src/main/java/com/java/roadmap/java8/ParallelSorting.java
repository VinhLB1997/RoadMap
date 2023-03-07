package com.java.roadmap.java8;

import java.util.Arrays;
import java.util.function.Supplier;

public class ParallelSorting {

    public int[] sortingArrayNormal(int[] arr){
        Arrays.sort(arr);
        return arr;
    }

    public int[] sortingArrayParallel(int[] arr){
        Arrays.parallelSort(arr);
        return arr;
    }

    public static void main(String[] args) {
        ParallelSorting test = new ParallelSorting();
        int[] arr = new int[100000000];
        for (int i = 0; i< 100000000; i++){
            arr[i] = i;
        }
        long startTime = System.nanoTime();
        int[] sortingArrayNormal = test.sortingArrayNormal(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  // thời gian thực thi của hàm calculateSum() tính bằng nano giây
        System.out.println("SortingArrayNormal: " + duration + " nanoseconds");

        long startTime1 = System.nanoTime();
        int[] sortingArrayParallel = test.sortingArrayParallel(arr);
        long endTime1 = System.nanoTime();
        long duration1 = (endTime - startTime);  // thời gian thực thi của hàm calculateSum() tính bằng nano giây
        System.out.println("sortingArrayParallel: " + duration1 + " nanoseconds");
    }
}
