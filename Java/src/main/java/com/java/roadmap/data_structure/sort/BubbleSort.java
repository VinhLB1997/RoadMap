package com.java.roadmap.data_structure.sort;

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

    void bubbleSort3(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    void bubbleSort4(int arr[]) {
        int n = arr.length;
        boolean isSwap = false;
        for (int i = 0; i < n; i++) {
            isSwap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arrOrigin = {12, 25, 21, 1, 5, 5, 235, 32, 12, 53, 66, 32, 22, 333, 2355325};
        bubbleSort.bubbleSort4(arrOrigin);
        for (int element : arrOrigin) {
            System.out.print(element);
            System.out.print("   ");
        }
    }
}
