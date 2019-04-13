package com.zh.learn.concurrency_test.design.event_bus;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class AsyncEventBus extends EventBus {

    public AsyncEventBus(String busName, EventExceptionHandler eventExceptionHandler, ThreadPoolExecutor executor) {
        super(busName, eventExceptionHandler, executor);
    }

    public AsyncEventBus(String busName, ThreadPoolExecutor executor) {
        this(busName, null, executor);
    }

    public AsyncEventBus(ThreadPoolExecutor executor) {
        this("default-async", null, executor);
    }

    public AsyncEventBus(EventExceptionHandler eventExceptionHandler, ThreadPoolExecutor executor) {
        this("default-async", eventExceptionHandler, executor);
    }
}
