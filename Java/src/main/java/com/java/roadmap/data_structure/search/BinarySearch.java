package com.java.roadmap.data_structure.search;

public class BinarySearch {

    public int binarySearch1(int[] arrSortedASC, int keySearch) {
        int left = 0;
        int right = arrSortedASC.length - 1;
        while (left <= right){
            int midIndex = (left + right)/2;
             if(arrSortedASC[midIndex] == keySearch){
                return midIndex;
            } else if(arrSortedASC[midIndex] > keySearch){
                 right = midIndex -1;
            } else if(arrSortedASC[midIndex] < keySearch){
                 left = midIndex + 1;
            }
        }
        return -1;
    }

    public int binarySearch2(int[] arrSortedDESC, int keySearch) {
        int left = 0;
        int right = arrSortedDESC.length - 1;
        while (left <= right){
            int midIndex = (left + right)/2;
            if(arrSortedDESC[midIndex] == keySearch){
                return midIndex;
            } else if(arrSortedDESC[midIndex] > keySearch){
                left = midIndex + 1;
            } else if(arrSortedDESC[midIndex] < keySearch){
                right = midIndex -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arrASC = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        int result1 = binarySearch.binarySearch1(arrASC, 13);
        System.out.println(result1 == -1 ? "Not found" :"Index Element need found is " + result1);
        int[] arrDESC = {324,32,22,11,10,9,8,7,6,5,4,3,2,1};
        int result2 = binarySearch.binarySearch2(arrDESC, -1);
        System.out.println( result2 == -1 ? "Not found" : "Index Element need found is " + result2);
    }
}
