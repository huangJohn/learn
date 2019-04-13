package com.zh.learn.concurrency_test.design.active_objects;

import com.zh.learn.concurrency_test.design.future.FutureTask;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class ActiveFuture<T> extends FutureTask<T> {

    @Override
    public void finish(T result) {
        super.finish(result);
    }
}
