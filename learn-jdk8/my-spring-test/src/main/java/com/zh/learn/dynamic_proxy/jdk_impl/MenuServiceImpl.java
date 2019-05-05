package com.zh.learn.dynamic_proxy.jdk_impl;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class MenuServiceImpl implements MenuService {

    @Override
    public void sayHello() {
        System.out.println("hello world.");
    }
}
