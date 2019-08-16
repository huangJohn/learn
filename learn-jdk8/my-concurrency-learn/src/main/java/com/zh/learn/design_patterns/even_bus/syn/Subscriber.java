package com.zh.learn.design_patterns.even_bus.syn;

import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public class Subscriber {

    private final Object subscriber;
    private final Method subscriberMethod;
    private boolean disable = false;

    public Subscriber(Object subscriber, Method method) {
        this.subscriber = subscriber;
        this.subscriberMethod = method;
    }

    public Object getSubscriber() {
        return subscriber;
    }

    public Method getSubscriberMethod() {
        return subscriberMethod;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
