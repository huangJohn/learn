package com.zh.algs.interview.top.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/9
 */
public class ThreeNumberSum {

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeNumberSum(arr);
        System.out.println(lists);

    }

    public static List<List<Integer>> threeNumberSum(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length < 3) {
            return res;
        }

        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                break;
            }

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    res.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

}
