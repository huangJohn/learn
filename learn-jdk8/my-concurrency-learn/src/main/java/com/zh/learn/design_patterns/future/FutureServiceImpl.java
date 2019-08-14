package com.zh.learn.design_patterns.future;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {

    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";

    private final AtomicInteger atomicInteger = new AtomicInteger();

    public String getNextName() {
        return FUTURE_THREAD_PREFIX + atomicInteger.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable) {

        final FutureTask<Void> future = new FutureTask<>();
        new Thread(() -> {
            runnable.run();
            future.finish(null);
        }, getNextName()).start();
        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {

        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            future.finish(result);
        }, getNextName()).start();
        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback) {

        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            future.finish(result);
            if (null != callback) {
                callback.call(result);
            }
        }, getNextName()).start();
        return future;
    }
}
