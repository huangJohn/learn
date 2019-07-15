package com.zh.learn.design_patterns.thread_observable;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */

@FunctionalInterface
public interface Task<T> {

    //任务执行接口，该接口允许有返回值
    T call();
}
