package com.zh.algs.interview.top.search;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/1
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 7, 10, 14, 19};
        System.out.println(searchByRecur(arr, 0, arr.length - 1, 10));
        System.out.println(searchByRecur(arr, 0, arr.length - 1, 15));
        System.out.println(searchByIter(arr, 0, arr.length - 1, 10));
        System.out.println(searchByIter(arr, 0, arr.length - 1, 15));

    }

    public static int searchByIter(int[] arr, int l, int h, int x) {

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }

    public static int searchByRecur(int[] arr, int l, int h, int x) {

        if (h >= l) {

            int mid = l + (h - l) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                return searchByRecur(arr, l, mid - 1, x);
            } else {
                return searchByRecur(arr, mid + 1, h, x);
            }
        }

        return -1;

    }

}
