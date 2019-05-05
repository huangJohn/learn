package com.zh.learn.simple_dubbo_with_spring;


import com.zh.learn.dynamic_proxy.jdk_impl.ProxyFactory;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class MyReferenceConfig<T> {

    private Class<?> interfaceClass;

    // 接口代理类引用
    private transient volatile T ref;

    public synchronized T get() {
        if (ref == null) {
            init();
        }
        return ref;
    }

    private void init() {
        ref = new ProxyFactory(interfaceClass).getProxyObject();
    }

    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

}
