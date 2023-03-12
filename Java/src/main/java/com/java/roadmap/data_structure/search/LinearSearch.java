package com.java.roadmap.data_structure.search;

public class LinearSearch {
    int linearSearch(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {638, 122, 541, 522, 810,715};
        LinearSearch linearSearch = new LinearSearch();
        int position = linearSearch.linearSearch(arr, 81);
        if(position == - 1){
            System.out.println("Element not found");
        } else {
            System.out.println("Vị trí phần tử cần tìm là " + position);
        }
    }
}
