package com.zh.learn.design_pattern_test.dynamic_proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 *
 * cglib针对一个类，生成子类，父类final方法不能代理
 */

public class CglibSayHelloProxy implements MethodInterceptor {

    public Object getProxy(Class<?> clz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object getProxy(Class<?> clz, Class<?>[] args, Object[] argsValue) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create(args, argsValue);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("调用之前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用之后");
        return result;
    }

}
