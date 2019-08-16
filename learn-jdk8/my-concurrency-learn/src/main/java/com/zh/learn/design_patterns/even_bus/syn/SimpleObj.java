package com.zh.learn.design_patterns.even_bus.syn;

import com.zh.learn.design_patterns.even_bus.Subscribe;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class SimpleObj {

    @Subscribe(topic = "1-topic")
    public void method1(String msg) {
        System.out.println("=====SimpleObj=====method1=====" + msg);
    }

    @Subscribe
    public void method2(String msg) {
        System.out.println("=====SimpleObj=====method2=====" + msg);
    }
}
