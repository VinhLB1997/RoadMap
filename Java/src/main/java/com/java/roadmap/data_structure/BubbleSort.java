package com.java.roadmap.data_structure;

import java.util.Arrays;

public class BubbleSort {

    void bubbleSort1(int arr[]) {
        int i, j;
        boolean haveSwap = false;
        for (i = 0; i < arr.length - 1; i++) {
            // i phần tử cuối cùng đã được sắp xếp
            haveSwap = false;
            for (j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    haveSwap = true; // Kiểm tra lần lặp này có swap không
                }
            }
            // Nếu không có swap nào được thực hiện => mảng đã sắp xếp. Không cần lặp thêm
            if (haveSwap == false) {
                break;
            }
        }
    }

    void bubbleSort2(int arrOrigin[]) {
        for (int i = 0; i < arrOrigin.length; i++) {
            for (int j = 0; j < arrOrigin.length; j++) {
                if (arrOrigin[i] > arrOrigin[j]) {
                    int temp = arrOrigin[i];
                    arrOrigin[i] = arrOrigin[j];
                    arrOrigin[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arrOrigin = {12, 25, 21, 1, 5, 5, 235, 32, 12, 53, 66, 32, 22};
        System.out.print(" BubbleSort 2  ");
        bubbleSort.bubbleSort2(arrOrigin);
        for (int i : arrOrigin) {
            System.out.print(i + "   ");
        }
        System.gc();
        System.out.print(" BubbleSort 1  ");
        int[] arrOriginTest = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        bubbleSort.bubbleSort1(arrOriginTest);
        for (int i : arrOrigin) {
            System.out.print(i + "   ");
        }
    }
}
