package com.zh.algs.sorting.select;

import com.zh.algs.sorting.utils.SortingUtils;
import gnu.trove.map.TMap;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-17
 */
public class SelectSort {

    /**
     * Description:
     * arr[] = 64 25 12 22 11
     *
     * // Find the minimum element in arr[0...4]
     * // and place it at beginning
     * 11 25 12 22 64
     *
     * // Find the minimum element in arr[1...4]
     * // and place it at beginning of arr[1...4]
     * 11 12 25 22 64
     *
     * // Find the minimum element in arr[2...4]
     * // and place it at beginning of arr[2...4]
     * 11 12 22 25 64
     *
     * // Find the minimum element in arr[3...4]
     * // and place it at beginning of arr[3...4]
     * 11 12 22 25 64
     *
     * time:O(n2)
     * space:O(1)
     */

    public static void sort(int[] arr) {

        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int currentMinIndex = i;
            //向后查找和当前i的值最小的index
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[currentMinIndex]) {
                    currentMinIndex = j;
                }
            }
            //交换
            int temp = arr[currentMinIndex];
            arr[currentMinIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{64, 25, 12, 22, 11};
        System.out.println("选择排序前：");
        SortingUtils.printArray(arr);
        sort(arr);
        System.out.println("选择排序后：");
        SortingUtils.printArray(arr);
    }

}
