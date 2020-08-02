package com.zh.algs.ds.array;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/31
 */
public class ReserveArray {

    public static void main(String[] args) {

        ReserveArray test = new ReserveArray();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        test.print(array);
        test.reserveArray(array, 0, array.length - 1);
        test.print(array);

        String s = "123456";
        char[] chars = s.toCharArray();
        test.reserveArray2(chars, 0, chars.length - 1);
        test.print2(chars);

    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void print2(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void reserveArray(int[] arr, int lo, int hi) {

        int tmp;

        while (lo < hi) {
            tmp = arr[hi];
            arr[hi] = arr[lo];
            arr[lo] = tmp;
            lo++;
            hi--;
        }
    }

    public void reserveArray2(char[] arr, int lo, int hi) {

        char tmp;

        while (lo < hi) {
            tmp = arr[hi];
            arr[hi] = arr[lo];
            arr[lo] = tmp;
            lo++;
            hi--;
        }
    }

}
