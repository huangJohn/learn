package com.zh.learn.design_patterns.future;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
@FunctionalInterface
public interface Callback<T> {

    //future任务完成后将结果t执行
    void call(T t);

}
