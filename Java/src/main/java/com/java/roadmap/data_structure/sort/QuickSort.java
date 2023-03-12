package com.java.roadmap.data_structure.sort;

public class QuickSort {

    void quickSort1(int[] arr, int begin, int end) {
        int pivot = arr[(begin + end) / 2];
        int stateBegin = begin;
        int stateEnd = end;
        while (stateBegin <= stateEnd) {
            while (arr[stateBegin] < pivot) {
                stateBegin++;
            }
            while (arr[stateEnd] > pivot) {
                stateEnd--;
            }
            if (stateBegin <= stateEnd) {
                int temp = arr[stateBegin];
                arr[stateBegin] = arr[stateEnd];
                arr[stateEnd] = temp;
                stateBegin++;
                stateEnd--;
            }
        }
        if (begin < stateEnd) {
            quickSort1(arr, begin, stateEnd);
        }
        if (stateBegin < end) {
            quickSort1(arr, stateBegin, end);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {2, 5, 4, 7, 345, 52, 34, 67, 54, 76, 12, 63, 12, 134, 1};
        quickSort.quickSort1(arr, 0, arr.length - 1);
        for (int element: arr){
            System.out.print(element);
            System.out.print("     ");
        }
    }
}
