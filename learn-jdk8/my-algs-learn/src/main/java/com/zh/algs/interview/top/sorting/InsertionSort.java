package com.zh.algs.interview.top.sorting;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/1
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {6, 1, 8, 10, 2, 4, 7, 5};
        BubbleSort.print(arr);
        insertionSort(arr);
        BubbleSort.print(arr);
    }


    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
