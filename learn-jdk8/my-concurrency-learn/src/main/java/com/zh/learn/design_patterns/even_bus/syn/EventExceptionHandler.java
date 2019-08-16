package com.zh.learn.design_patterns.even_bus.syn;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public interface EventExceptionHandler {


    void handle(Throwable e, EventContext eventContext);
}
