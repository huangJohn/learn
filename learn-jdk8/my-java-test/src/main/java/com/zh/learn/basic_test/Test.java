package com.zh.learn.basic_test;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/28
 */
public class Test {

    public static void main(String[] args) {

        String s = "7.21";

        System.out.println(NumberUtils.isNumber(s));

        String s1 = "-777";
        System.out.println(Integer.valueOf(s1));

        System.out.println(-Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}
