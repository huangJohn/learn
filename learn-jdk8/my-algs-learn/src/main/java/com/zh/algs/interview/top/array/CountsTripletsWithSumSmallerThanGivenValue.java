package com.zh.algs.interview.top.array;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/1
 */
public class CountsTripletsWithSumSmallerThanGivenValue {

    public static int counts(int[] arr, int sum) {
        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] < sum) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {


        int[] arr = new int[]{5, 1, 3, 4, 7};
        System.out.println(counts(arr, 12));


    }
}
