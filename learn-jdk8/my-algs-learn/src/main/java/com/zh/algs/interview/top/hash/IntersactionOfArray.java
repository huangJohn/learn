package com.zh.algs.interview.top.hash;

import com.zh.algs.sorting.utils.SortingUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/7
 */
public class IntersactionOfArray {

    public static void main(String[] args) {

        int[] ints = intersactionOfArray(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        SortingUtils.printArray(ints);
    }

    public static int[] intersactionOfArray(int[] arr, int[] arr2) {

        if (arr == null || arr2 == null) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                set1.add(arr2[i]);
            }
        }

        int[] res = new int[set1.size()];
        int j = 0;
        for (Integer integer : set1) {
            res[j] = integer;
            j++;
        }
        return res;
    }

}
