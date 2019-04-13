package com.zh.learn.design_pattern_test.adapter.adapter_of_interface;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class Chat extends Wrapper {

    @Override
    public void net() {
        System.out.println("chat net is running.");
    }

    @Override
    public void ftp() {
        System.out.println("chat ftp is running.");
    }
}
