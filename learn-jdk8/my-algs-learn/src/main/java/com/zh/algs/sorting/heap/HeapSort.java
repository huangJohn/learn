package com.zh.algs.sorting.heap;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-18
 */
public class HeapSort {

    public static void sort(int[] arr) {

        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6, 7};
        SortingUtils.printArray(arr);
        sort(arr);
        SortingUtils.printArray(arr);
    }

}
