package com.zh.learn.basic_test;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-18
 */
public class BasicTest {

    public static void main(String[] args) {

        String misc = "0|||0|000000|0|kaola|83jp9-a60172368a721f52cb0b71a0173c206b";

        String[] split = misc.split("\\|");

        System.out.println(split.length);

        System.out.println(split[6]);
    }

}
