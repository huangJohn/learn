package com.zh.learn.dynamic_proxy.jdk_impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:基于jdk的动态代理
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class ProxyFactory implements InvocationHandler {

    private Class interfaceClass;

    public ProxyFactory(Class interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    //返回代理对象,此处用泛型为了调用时不用强转,用Object需要强转
    public <T> T getProxyObject() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{interfaceClass}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy method = " + method);
        System.out.println("开始编码");
        System.out.println("发送网络请求");
        System.out.println("接受到网络响应，解码并返回");
        return null;
    }
}
