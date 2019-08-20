package com.zh.algs.sorting.insertion;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-17
 */
public class Insertion {

    /**
     * Description:
     * 12, 11, 13, 5, 6
     *
     * Let us loop for i = 1 (second element of the array) to 4 (last element of the array)
     *
     * i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
     * 11, 12, 13, 5, 6
     *
     * i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
     * 11, 12, 13, 5, 6
     *
     * i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
     * 5, 11, 12, 13, 6
     *
     * i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
     * 5, 6, 11, 12, 13
     *
     * n2
     * 1
     */
    public static void sort(int[] arr) {

        int length = arr.length;

        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void sortByRecursively(int[] arr) {

    }

    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6};
        SortingUtils.printArray(arr);
        sort(arr);
        SortingUtils.printArray(arr);
    }



}
