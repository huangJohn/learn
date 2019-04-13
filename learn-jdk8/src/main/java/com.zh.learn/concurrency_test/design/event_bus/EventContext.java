package com.zh.learn.concurrency_test.design.event_bus;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public interface EventContext {

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
