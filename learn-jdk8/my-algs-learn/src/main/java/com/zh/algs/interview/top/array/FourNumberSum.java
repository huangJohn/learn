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
public class FourNumberSum {

    public static void main(String[] args) {

        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(fourNumberSum(arr, 0));
    }

    public static List<List<Integer>> fourNumberSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < n; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int c = b + 1, d = n - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        results.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c + 1] == nums[c]) {
                            c++;
                        }
                        while (c < d && nums[d - 1] == nums[d]) {
                            d--;
                        }
                        c++;
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return results;
    }


}
