package com.zh.learn.design_patterns.even_bus.syn;

import com.zh.learn.design_patterns.even_bus.Subscribe;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class SimpleObj2 {

    @Subscribe
    public void method1(String msg) {
        System.out.println("=====SimpleObj2=====method1=====" + msg);
    }

    @Subscribe(topic = "2-topic")
    public void method2(String msg) {
        System.out.println("=====SimpleObj2=====method2=====" + msg);
    }
}
