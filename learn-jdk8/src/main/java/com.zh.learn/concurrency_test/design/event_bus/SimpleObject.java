package com.zh.learn.concurrency_test.design.event_bus;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class SimpleObject {

    /**
     * subscribe方法，用@Subscribe标记，并且是void，有一个入参
     */

    @Subscribe(topic = "alex-topic")
    public void test2(Integer x) {

    }

    @Subscribe(topic = "test-topic")
    public void test3(Integer x) {

    }
}
