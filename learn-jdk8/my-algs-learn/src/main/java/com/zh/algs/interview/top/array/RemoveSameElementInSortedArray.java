package com.zh.algs.interview.top.array;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class RemoveSameElementInSortedArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 3, 4, 5, 6, 6, 8};
        SortingUtils.printArray(arr);
        int[] ints = removeDup(arr);
        SortingUtils.printArray(ints);
    }

    public static int[] removeDup(int[] arr) {

        int i = 0, j = 1;
        int n = arr.length;

        while (j < n) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
            }
            j++;
        }
        int[] ret = new int[i + 1];
        System.arraycopy(arr, 0, ret, 0, i + 1);
        return ret;
    }

}
