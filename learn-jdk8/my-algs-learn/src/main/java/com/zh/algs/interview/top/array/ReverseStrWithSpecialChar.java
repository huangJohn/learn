package com.zh.algs.interview.top.array;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/31
 */
public class ReverseStrWithSpecialChar {

    public static void main(String[] args) {

        String str = "a!!!b.c.d,e'f,ghi";
        char[] chars = str.toCharArray();
        reverse(chars);

        String s = ArrayUtils.toString(chars);
        System.out.println(s);


    }

    public static void reverse(char[] chars) {

        int hi = chars.length - 1;
        int lo = 0;

        while (lo < hi) {
            if (!Character.isAlphabetic(chars[lo])) {
                lo++;
            } else if (!Character.isAlphabetic(chars[hi])) {
                hi--;
            } else {
                char tmp = chars[lo];
                chars[lo] = chars[hi];
                chars[hi] = tmp;
                lo++;
                hi--;
            }
        }
    }



}
