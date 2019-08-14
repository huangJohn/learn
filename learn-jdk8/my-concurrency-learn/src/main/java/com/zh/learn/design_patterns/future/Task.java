package com.zh.learn.design_patterns.future;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */

@FunctionalInterface
public interface Task<IN, OUT> {

    //给定一个参数，经过计算返回结果
    OUT get(IN input);
}
