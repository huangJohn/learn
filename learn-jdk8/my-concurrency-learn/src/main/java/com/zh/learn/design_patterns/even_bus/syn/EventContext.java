package com.zh.learn.design_patterns.even_bus.syn;

import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public interface EventContext {

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();

}
