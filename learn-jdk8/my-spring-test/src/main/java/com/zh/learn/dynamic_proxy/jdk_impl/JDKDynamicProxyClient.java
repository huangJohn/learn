package com.zh.learn.dynamic_proxy.jdk_impl;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class JDKDynamicProxyClient {

    public static void main(String[] args) {

        ProxyFactory proxyFactory = new ProxyFactory(MenuService.class);
        MenuService menuService = (MenuService) proxyFactory.getProxyObject();
        menuService.sayHello();
    }

}
