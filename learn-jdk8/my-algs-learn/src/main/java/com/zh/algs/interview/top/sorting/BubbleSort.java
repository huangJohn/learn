package com.zh.algs.interview.top.sorting;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/1
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {6, 1, 8, 10, 2, 4, 7, 5};
        print(arr);
        bubbleSort(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

    }

}
