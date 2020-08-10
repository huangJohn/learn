package com.zh.algs.interview.top.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/9
 */
public class FourNumberSum2 {

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};

        System.out.println(fourNumberSum2(a, b, c, d));
    }

    public static int fourNumberSum2(int[] a, int[] b, int[] c, int[] d) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sum = a[i] + b[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                int sum = c[i] + b[j];
                if (map.containsKey(-sum)) {
                    res++;
                }
            }
        }

        return res;
    }
}
