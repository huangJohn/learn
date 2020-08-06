package com.zh.algs.interview.top.string;

import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/6
 */
public class ReverseString2K {

    public static void main(String[] args) {

        String s = "123abcdefg";
        char[] chars = s.toCharArray();
        SortingUtils.printArray(chars);
        reverseString2(chars, 4);
        SortingUtils.printArray(chars);
    }

    public static void reverseString2(char[] chars, int k) {

        for (int i = 0; i < chars.length; i = i + 2 * k) {
            if (i + k <= chars.length) {
                reverse(chars, i, i + k - 1);
                continue;
            }
            reverse(chars, i, chars.length - 1);
        }
    }

    private static void reverse(char[] chars, int lo, int hi) {
        for (int i = lo, j = hi; i < lo + (hi - lo + 1) / 2; i++, j--) {
            swap(chars, i, j);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }


}
