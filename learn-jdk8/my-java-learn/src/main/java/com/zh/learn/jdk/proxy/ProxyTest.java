package com.zh.learn.jdk.proxy;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/11/23
 */
public class ProxyTest {

    public static void main(String[] args) {


        UserService userService = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) myInvocationHandler.getProxy();

        proxy.add();
    }

}
