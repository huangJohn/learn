package com.zh.learn.design_patterns.event_driven.sync;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class Event implements Message {

    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }
}
