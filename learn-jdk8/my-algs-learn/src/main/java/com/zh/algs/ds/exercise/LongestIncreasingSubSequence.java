package com.zh.algs.ds.exercise;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/13
 */
public class LongestIncreasingSubSequence {

    public static void main(String[] args) {

        int[] nums = {1, 7, 5, 6, 3, 4};
        System.out.println(lengthOfLIS(nums));
        int[] nums2 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums2));
    }


    public static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
