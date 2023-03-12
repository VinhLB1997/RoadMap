package com.java.roadmap.data_structure.sort;

public class SelectionSort {

    void selectionSort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int indexValueMin = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[indexValueMin] > arr[j]) {
                    indexValueMin = j;
                }
            }
            if (indexValueMin != i) {
                int temp = arr[i];
                arr[i] = arr[indexValueMin];
                arr[indexValueMin] = temp;
            }
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = {344,6,7,423,7,8,5,4,2,57,34,8,45,78,1};
        selectionSort.selectionSort1(arr);
        for (int element : arr){
            System.out.print(element);
            System.out.print("   ");
        }
    }
}
