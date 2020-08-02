package com.zh.algs.interview.top.sorting;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/1
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        SortingUtils.printArray(arr);
        mergerSort(arr, 0, arr.length - 1);
        SortingUtils.printArray(arr);
    }

    public static void mergerSort(int[] arr, int lo, int hi) {

        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergerSort(arr, lo, mid);
            mergerSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }

    }

    private static void merge(int[] arr, int lo, int mid, int hi) {

        int n1 = mid - lo + 1;//(0,1) left={0}, right={1}, lo=mid=0, hi=1
        int n2 = hi - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[lo + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = lo;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

}
