package com.zh.algs.interview.top.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/8
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(18));
        System.out.println(isHappy(1239213999));
    }

    public static boolean isHappy(int num) {
        Set<Integer> set = new HashSet<>();
        while (num != 1 && !set.contains(num)) {
            set.add(num);
            num = getNext(num);
        }
        return num == 1;
    }

    private static int getNext(int num) {

        /**
         * Description:
         * 111 = 1*1 + 1*1 + 1*1
         */
        int sum = 0;
        while (num > 0) {
            int d = num % 10;
            num = num / 10;
            sum = sum + d * d;
        }
        return sum;
    }

}
