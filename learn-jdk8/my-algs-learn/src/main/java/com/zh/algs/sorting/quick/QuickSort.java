package com.zh.algs.sorting.quick;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-18
 */
public class QuickSort {

    /**
     * Description:
     * arr[] = {10, 80, 30, 90, 40, 50, 70}
     * Indexes:  0   1   2   3   4   5   6
     *
     * low = 0, high =  6, pivot = arr[h] = 70
     * Initialize index of smaller element, i = -1
     *
     * Traverse elements from j = low to high-1
     * j = 0 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
     * i = 0
     * arr[] = {10, 80, 30, 90, 40, 50, 70} // No change as i and j
     *                                      // are same
     *
     * j = 1 : Since arr[j] > pivot, do nothing
     * // No change in i and arr[]
     *
     * j = 2 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
     * i = 1
     * arr[] = {10, 30, 80, 90, 40, 50, 70} // We swap 80 and 30
     *
     * j = 3 : Since arr[j] > pivot, do nothing
     * // No change in i and arr[]
     *
     * j = 4 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
     * i = 2
     * arr[] = {10, 30, 40, 90, 80, 50, 70} // 80 and 40 Swapped
     * j = 5 : Since arr[j] <= pivot, do i++ and swap arr[i] with arr[j]
     * i = 3
     * arr[] = {10, 30, 40, 50, 80, 90, 70} // 90 and 50 Swapped
     *
     * We come out of loop because j is now equal to high-1.
     * Finally we place pivot at correct position by swapping
     * arr[i+1] and arr[high] (or pivot)
     * arr[] = {10, 30, 40, 50, 70, 90, 80} // 80 and 70 Swapped
     *
     * Now 70 is at its correct place. All elements smaller than
     * 70 are before it and all elements greater than 70 are after
     * it.
     */

    public static void sort(int[] arr, int low, int high) {

        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        //指定pivot=arr[high]
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        //i+1左边都比i+1小，右边比i+1大
        return i + 1;

        /**
         * Description:
         * time best nlogn
         *      worst n2
         *      average nlogn
         * not stable
         */

    }

    public static void main(String[] args) {

        int arr[] = {10, 7, 8, 9, 1, 5};
        SortingUtils.printArray(arr);
        sort(arr, 0, arr.length - 1);
        SortingUtils.printArray(arr);
    }

}
