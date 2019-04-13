package com.zh.learn.design_pattern_test.dynamic_proxy.cglib;

import com.zh.learn.design_pattern_test.dynamic_proxy.jdk.SayHello;
import com.zh.learn.design_pattern_test.dynamic_proxy.jdk.SayHelloImpl;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 */

public class Client {
    public static void main(String[] args) {

        SayHello sayHello = new SayHelloImpl();
        SayHello proxy = (SayHello) new CglibSayHelloProxy().getProxy(sayHello.getClass());
        proxy.sayHello();

        ICode iCode = new JavaCoder("zhuang");
        JavaCoder proxy1 = (JavaCoder) new CglibSayHelloProxy().getProxy(iCode.getClass(), new Class[]{String.class}, new String[]{((JavaCoder) iCode).getName()});
        proxy1.implDemand("asd");

    }
}
