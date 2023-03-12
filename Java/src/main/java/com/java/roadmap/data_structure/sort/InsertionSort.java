package com.java.roadmap.data_structure.sort;

public class InsertionSort {

    void insertionSort1(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int currentIndexMinValue  = i;
            for (int j = i -1; j >= 0; j--){
                if (arr[currentIndexMinValue] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[currentIndexMinValue];
                    arr[currentIndexMinValue] = temp;
                    currentIndexMinValue = j;
                }
            }
        }

    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {4,2,5,5,2354,25,1,635,32,765,23,23,1,6,5,1,1,8324758,83489540,2392,11};
        insertionSort.insertionSort1(arr);
        for (int element : arr){
            System.out.print(element);
            System.out.print("   ");
        }
    }
}
