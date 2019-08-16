package com.zh.learn.design_patterns.even_bus.syn;

import com.zh.learn.design_patterns.even_bus.Bus;

import java.util.concurrent.Executor;


/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public class EventBus implements Bus {

    private String busName;

    //维护subscriber的注册表
    private final Registry registry = new Registry();

    private final static String DEFAULT_BUS_NAME = "default-syn-bus";

    private final static String DEFAULT_TOPIC_NAME = "default-topic";

    //广播消息到各个Subscriber
    private final Dispatcher dispatcher;

    public EventBus() {
        this(DEFAULT_BUS_NAME, null, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public EventBus(String busName) {
        this(busName, null, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public EventBus(EventExceptionHandler eventExceptionHandler) {
        this(DEFAULT_BUS_NAME, eventExceptionHandler, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public EventBus(String busName, EventExceptionHandler eventExceptionHandler, Executor executor) {
        this.busName = busName;
        this.dispatcher = new Dispatcher(eventExceptionHandler, executor);
    }

    @Override
    public void register(Object subscriber) {
        this.registry.bind(subscriber);
    }

    @Override
    public void unRegister(Object subscriber) {
        this.registry.unBind(subscriber);
    }

    @Override
    public void post(Object event) {
        this.post(event, DEFAULT_TOPIC_NAME);
    }

    @Override
    public void post(Object event, String topic) {
        this.dispatcher.dispatch(this, registry, event, topic);
    }

    @Override
    public void close() {
        this.dispatcher.close();
    }

    @Override
    public String getBusName() {
        return this.busName;
    }
}
