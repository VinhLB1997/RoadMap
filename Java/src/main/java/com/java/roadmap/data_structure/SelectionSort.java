package com.java.roadmap.data_structure;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arrOrigin = {12, 25, 21, 1, 5, 5, 235, 32, 12, 53, 66, 32, 22};
        int i, j, k, pos, temp;
        for (i = 0; i < arrOrigin.length; i++) {
            pos = smallest(arrOrigin, 10, i);
            temp = arrOrigin[i];
            arrOrigin[i] = arrOrigin[pos];
            arrOrigin[pos] = temp;
        }
        System.out.println("\nprinting sorted elements...\n");
        for (i = 0; i < arrOrigin.length; i++) {
            System.out.print(arrOrigin[i]+ "  ");
        }
    }

    public static int smallest(int arrOrigin[], int n, int i) {
        int small, pos, j;
        small = arrOrigin[i];
        pos = i;
        for (j = i + 1; j < arrOrigin.length; j++) {
            if (arrOrigin[j] < small) {
                small = arrOrigin[j];
                pos = j;
            }
        }
        return pos;
    }
}
