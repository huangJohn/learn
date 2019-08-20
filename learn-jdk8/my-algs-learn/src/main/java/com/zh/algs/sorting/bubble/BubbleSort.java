package com.zh.algs.sorting.bubble;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-17
 */
public class BubbleSort {

    /**
     * Description:
     * Example:
     * First Pass:
     * ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
     * ( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
     * ( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
     * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
     * <p>
     * Second Pass:
     * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
     * ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
     * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
     * ( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
     * Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.
     * <p>
     * Third Pass:
     * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
     * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
     * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
     * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
     * <p>
     * Fourth Pass:
     * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
     * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
     * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
     * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
     */

    public static void sort(int[] arr) {

        int length = arr.length;

        //比较几次，每次比较完最大index顺序排好
        for (int i = 0; i < length - 1; i++) {
            //每次具体比较
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        /**
         * Description:
         * 无论如何都要n2
         * time O(n2)
         * space O(1)
         */
    }

    public static void sortOptimized(int[] arr) {

        int length = arr.length;

        boolean swapped;
        //比较几次
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            //每次具体比较
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }

            //j和j+1没有一次交换，说名已经排好，直接break
            if (!swapped) {
                break;
            }
        }

        /**
         * Description:
         * time 最好O(n)，最差O(n2)
         * space O(1)
         */
    }

    public static void sortByRecursively(int[] arr, int length) {

        for (int i = 0; i < length - 1; i++) {

            //递归返回条件
            if (length == 1) {
                return;
            }

            //swap
            if (arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }

            //当前已经处理好，递归
            sortByRecursively(arr, length - 1);
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        System.out.println("冒泡选择前：");
        SortingUtils.printArray(arr);
        sort(arr);
        System.out.println("冒泡选择后：");
        SortingUtils.printArray(arr);

        int[] arr2 = new int[]{64, 34, 25, 12, 22, 11, 90};
        System.out.println("优化的冒泡选择前：");
        SortingUtils.printArray(arr2);
        sortOptimized(arr2);
        System.out.println("优化的冒泡选择后：");
        SortingUtils.printArray(arr2);

        int[] arr3 = new int[]{64, 34, 25, 12, 22, 11, 90};
        System.out.println("递归冒泡选择前：");
        SortingUtils.printArray(arr3);
        sortByRecursively(arr3, arr3.length);
        System.out.println("递归冒泡选择后：");
        SortingUtils.printArray(arr3);
    }


}
