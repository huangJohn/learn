package com.zh.learn.design_patterns.even_bus.async;

import com.zh.learn.design_patterns.even_bus.Bus;
import com.zh.learn.design_patterns.even_bus.syn.EventBus;
import com.zh.learn.design_patterns.even_bus.syn.EventExceptionHandler;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(String busName, EventExceptionHandler eventExceptionHandler, ThreadPoolExecutor executor) {
        super(busName, eventExceptionHandler, executor);
    }

    public AsyncEventBus(String busName, ThreadPoolExecutor executor) {
        this(busName, null, executor);
    }

    public AsyncEventBus(ThreadPoolExecutor executor) {
        this("default-async-bus", null, executor);
    }

    public AsyncEventBus(EventExceptionHandler eventExceptionHandler, ThreadPoolExecutor executor) {
        this("default-async-bus", eventExceptionHandler, executor);
    }
}
