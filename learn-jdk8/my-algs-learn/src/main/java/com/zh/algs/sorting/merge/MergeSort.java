package com.zh.algs.sorting.merge;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-17
 */
public class MergeSort {

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {

        //求两个数组的大小
        //left
        int n1 = mid - l + 1;
        //right
        int n2 = r - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        //copy left
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        //copy right
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6, 7};
        SortingUtils.printArray(arr);
        sort(arr, 0, arr.length - 1);
        SortingUtils.printArray(arr);

        /**
         * Description:
         * nlogn
         * n
         */
    }

}
