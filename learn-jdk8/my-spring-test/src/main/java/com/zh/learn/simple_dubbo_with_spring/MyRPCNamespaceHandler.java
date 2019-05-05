package com.zh.learn.simple_dubbo_with_spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class MyRPCNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("reference", new MyRPCBeanDefinitionParser());
    }
}
