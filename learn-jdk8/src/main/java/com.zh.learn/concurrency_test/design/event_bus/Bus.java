package com.zh.learn.concurrency_test.design.event_bus;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public interface Bus {

    /**
     * 将某个对象注册到Bus上，该类就成为Subscriber
     */
    void register(Object subscriber);

    /**
     * 取消注册，不再接收来自Bus的任何消息
     */
    void unregister(Object subscriber);

    /**
     * 提交Event到默认的topic上
     */
    void post(Object event);

    /**
     * 提交Event到指定的topic上
     */
    void post(Object event, String topic);

    /**
     * 关闭Bus
     */
    void close();

    /**
     * 返回Bus的名字
     */
    String getBusName();
}
