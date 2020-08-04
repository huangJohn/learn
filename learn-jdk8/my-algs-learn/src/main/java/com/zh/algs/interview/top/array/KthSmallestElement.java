package com.zh.algs.interview.top.array;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/3
 */
public class KthSmallestElement {

    public static void main(String[] args) {

        int[] arr = {10, 4, 7, 2, 13, 6, 10};
        System.out.println(kThSmallest(arr, 0, arr.length - 1, 1));
        System.out.println(kThMax(arr, 0, arr.length - 1, 5));

    }

    public static int kThMax(int[] arr, int lo, int hi, int k) {

        if (k == 0) {
            throw new RuntimeException("illegal");
        }

        int index = arr.length - k;

        if (index < 0) {
            return Integer.MIN_VALUE;
        }

        while (lo < hi) {
            int partition = partition(arr, lo, hi);
            if (partition < index) {
                lo = partition + 1;
            } else if (partition > index) {
                hi = partition - 1;
            } else {
                return arr[partition];
            }
        }
        return arr[lo];
    }

    public static int kThSmallest(int[] arr, int lo, int hi, int k) {

        int index = k - 1;

        if (index < 0) {
            throw new RuntimeException("illegal");
        }

        if (index > arr.length - 1) {
            return Integer.MAX_VALUE;
        }

        while (lo < hi) {
            int partition = partition(arr, lo, hi);
            if (partition < index) {
                lo = partition + 1;
            } else if (partition > index) {
                hi = partition - 1;
            } else {
                return arr[partition];
            }
        }
        return arr[lo];
    }

    private static int partition(int[] arr, int lo, int hi) {

        int key = lo;
        int tmp;

        while (lo <= hi) {
            while (lo <= hi && arr[lo] <= arr[key]) {
                lo++;
            }
            while (lo <= hi && arr[hi] >= arr[key]) {
                hi--;
            }

            if (lo > hi) {
                break;
            }

            tmp = arr[hi];
            arr[hi] = arr[lo];
            arr[lo] = tmp;
        }

        tmp = arr[hi];
        arr[hi] = arr[key];
        arr[key] = tmp;
        return hi;
    }

}
