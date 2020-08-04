package com.zh.algs.ds.array;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class MergeTwoSortedArray {

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 10, 12};

        int[] ret = mergeTwo(arr1, arr2);
        SortingUtils.printArray(ret);
    }

    public static int[] mergeTwo(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr3[k] = arr1[i];
                k++;
                i++;
            } else {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }

        while (i < arr1.length) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }

        return arr3;
    }

}
