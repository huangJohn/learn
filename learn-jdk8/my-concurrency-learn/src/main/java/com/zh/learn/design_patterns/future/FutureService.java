package com.zh.learn.design_patterns.future;

import java.util.function.Consumer;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 *
 * 桥接Future和FutureTask
 */
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task) {

        AsynFuture<T> future = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            future.done(result);
        }).start();
        return future;
    }

    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer) {
        AsynFuture<T> future = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            future.done(result);
            consumer.accept(result);
        }).start();
        return future;
    }

}
