package com.zh.algs.interview.top.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/8
 */
public class DupElement2 {

    public static void main(String[] args) {

        boolean b = dupElement2(new int[]{1, 2, 3, 1, 2, 3}, 2);
        System.out.println(b);
        System.out.println(dupElement2(new int[]{1, 2, 3, 1}, 3));
    }

    public static boolean dupElement2(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                Integer integer = map.get(arr[i]);
                int distance = Math.abs(integer - i);
                if (distance <= k) {
                    return true;
                }
            }
        }
        return false;
    }

}
