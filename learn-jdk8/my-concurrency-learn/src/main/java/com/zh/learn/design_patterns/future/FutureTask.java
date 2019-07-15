package com.zh.learn.design_patterns.future;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 *
 * 将调用执行逻辑进行了隔离
 */
public interface FutureTask<T> {

    T call();

}
