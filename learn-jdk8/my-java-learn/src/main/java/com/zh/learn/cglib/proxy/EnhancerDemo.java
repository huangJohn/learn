package com.zh.learn.cglib.proxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/11/30
 */
public class EnhancerDemo {


    public static void main(String[] args) {


        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());
        EnhancerDemo enhancerDemo = (EnhancerDemo) enhancer.create();
        enhancerDemo.test();

        System.out.println(enhancerDemo);
    }

    public void test() {
        System.out.println("EnhancerDemo test()");

    }

}
