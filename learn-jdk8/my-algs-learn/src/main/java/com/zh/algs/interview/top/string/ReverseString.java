package com.zh.algs.interview.top.string;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/6
 */
public class ReverseString {

    public static void main(String[] args) {

        String s = "123abcde";
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        SortingUtils.printArray(chars);
    }

    public static void reverse(char[] chars, int lo, int hi) {

        for (int i = 0, j = hi; i < (hi - lo + 1) / 2; i++, j--) {
            swap(chars, i, j);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}
