package com.zh.algs.interview.top.array;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/3
 */
public class LargestSubArrayLengthWithContiguousElements {

    public static void main(String[] args) {

        int[] arr = {1, 56, 57, 58, 90, 92, 91, 94, 93, 45};
        System.out.println(findLength(arr, arr.length));

    }

    public static int min(int x, int y) {
        return Math.min(x, y);
    }

    public static int max(int x, int y) {
        return Math.max(x, y);
    }

    public static int findLength(int[] arr, int n) {
        int maxLen = 1;
        for (int i = 0; i < n - 1; i++) {
            //每次先置自己为min，max
            int min = arr[i];
            int max = arr[i];
            for (int j = i + 1; j < n; j++) {
                min = min(arr[j], min);
                max = max(arr[j], max);

                //最长连续单增数组距离值=index差
                if (max - min == j - i) {
                    maxLen = max(maxLen, max - min + 1);
                }
            }
        }
        return maxLen;
    }

}
