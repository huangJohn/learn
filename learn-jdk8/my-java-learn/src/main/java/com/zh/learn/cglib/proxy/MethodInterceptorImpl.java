package com.zh.learn.cglib.proxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/11/30
 */
public class MethodInterceptorImpl implements MethodInterceptor {

//    private EnhancerDemo target;
//
//    public MethodInterceptorImpl(EnhancerDemo target) {
//        super();
//        this.target = target;
//    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before invoke " + method);
        Object result = proxy.invokeSuper(object, args);
        System.out.println("after invoke " + method);
        return result;
    }
}
