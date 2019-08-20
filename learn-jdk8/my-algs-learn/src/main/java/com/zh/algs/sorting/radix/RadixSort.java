package com.zh.algs.sorting.radix;

import com.zh.algs.sorting.utils.SortingUtils;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-20
 */
public class RadixSort {

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void sort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private static int getMax(int[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > ret) {
                ret = arr[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        SortingUtils.printArray(arr);
        sort(arr);
        SortingUtils.printArray(arr);
    }


}
