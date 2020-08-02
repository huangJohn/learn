package com.zh.algs.interview.top.sorting;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/1
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {10, 7, 8, 9, 1, 5};
        SortingUtils.printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        SortingUtils.printArray(arr);
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {

        int pivot = arr[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[hi];
        arr[hi] = tmp;
        return i + 1;
    }

}
