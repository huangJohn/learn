package com.zh.learn.design_patterns.event_driven.async;

import com.zh.learn.design_patterns.event_driven.sync.Channel;
import com.zh.learn.design_patterns.event_driven.sync.Event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public abstract class AsyChannel implements Channel<Event> {

    private final ExecutorService executorService;


    public AsyChannel(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public AsyChannel() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
    }

    @Override
    public final void dispatch(Event message) {
        executorService.submit(() -> {
            this.handler(message);
        });
    }

    protected abstract void handler(Event message);

    public void stop() {
        if (null != executorService && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
