package com.zh.algs.interview.top.array;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class SubArraySumMinLength {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(subArraySumMinLength(arr, 7));
    }

    public static int subArraySumMinLength(int[] arr, int x) {

        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;

        while (j < n) {
            sum = sum + arr[j];
            while (sum >= x) {
                len = Math.min(len, j - i + 1);
                sum = sum - arr[i];
                i++;
            }
            j++;
        }

        return len;
    }

}
