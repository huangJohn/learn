package com.zh.algs.interview.top.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class FindOnceNumber {

    public static void main(String[] args) {

        int[] arr = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
        System.out.println(getSingle(arr));


    }


    public static int getSingle(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int setSum = 0;
        for (int i : set) {
            setSum = setSum + i;
        }


        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }

        return (3 * setSum - sum) / 2;
    }

}
