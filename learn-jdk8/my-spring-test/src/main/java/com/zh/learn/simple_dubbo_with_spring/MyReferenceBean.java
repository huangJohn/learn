package com.zh.learn.simple_dubbo_with_spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class MyReferenceBean<T> extends MyReferenceConfig<T> implements FactoryBean<T> {


    @Override
    public T getObject() throws Exception {
        return get();
    }

    @Override
    public Class<?> getObjectType() {
        return getInterfaceClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
