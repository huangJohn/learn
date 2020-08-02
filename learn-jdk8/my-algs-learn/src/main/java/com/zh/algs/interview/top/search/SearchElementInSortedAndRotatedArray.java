package com.zh.algs.interview.top.search;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/1
 */
public class SearchElementInSortedAndRotatedArray {

    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 8));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 2));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 1));
        System.out.println(binarySearch(arr, 0, arr.length - 1, 13));
    }

    public static int binarySearch(int[] arr, int l, int h, int key) {
        if (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            if (arr[l] <= arr[mid]) {
                if (key >= arr[l] && key <= arr[mid]) {
                    return binarySearch(arr, l, mid - 1, key);
                } else {
                    return binarySearch(arr, mid + 1, h, key);
                }
            } else {
                if (key >= arr[mid] && key <= arr[h]) {
                    return binarySearch(arr, mid + 1, h, key);
                } else {
                    return binarySearch(arr, l, mid - 1, key);
                }
            }

        }
        return -1;
    }

}
