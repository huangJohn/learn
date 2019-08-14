package com.zh.learn.design_patterns.active_objects.standard;


import com.zh.learn.design_patterns.future.FutureTask;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
public class ActiveFuture<T> extends FutureTask<T> {

    @Override
    public void finish(T result) {
        super.finish(result);
    }
}
