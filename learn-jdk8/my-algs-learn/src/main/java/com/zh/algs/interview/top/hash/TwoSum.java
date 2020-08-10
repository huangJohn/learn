package com.zh.algs.interview.top.hash;

import com.zh.algs.sorting.utils.SortingUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/8
 */
public class TwoSum {

    public static void main(String[] args) {

        SortingUtils.printArray(twoSum(new int[]{1, 2, 10, 4, 6}, 11));

    }

    public static int[] twoSum(int[] arr, int sum) {

        /**
         * Description:
         * 1,2,3,4,5      5
         * 0 1
         */
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(sum - arr[i])) {
                map.put(arr[i], i);
            } else {
                return new int[]{map.get(sum - arr[i]), i};
            }
        }

        return new int[0];
    }

}
