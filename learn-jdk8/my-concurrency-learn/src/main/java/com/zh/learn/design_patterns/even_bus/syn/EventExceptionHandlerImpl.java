package com.zh.learn.design_patterns.even_bus.syn;

import com.alibaba.fastjson.JSON;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class EventExceptionHandlerImpl implements EventExceptionHandler {

    @Override
    public void handle(Throwable e, EventContext eventContext) {
        System.out.println(eventContext.getEvent() + " " + eventContext.getSource() + " " + eventContext.getSubscriber() + " " + eventContext.getSubscribe());
//        throw new RuntimeException(e.getMessage());
    }
}
