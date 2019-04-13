package com.zh.learn.design_pattern_test.static_proxy;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 */

public class Customer {

    public static void main(String[] args) {

        ICoder iCoder = new JavaCoder("zhuang");
        ICoder proxy = new CoderProxy(iCoder);
        proxy.implDemands("add user");
    }
}
