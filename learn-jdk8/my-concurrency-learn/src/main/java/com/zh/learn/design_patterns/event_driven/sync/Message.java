package com.zh.learn.design_patterns.event_driven.sync;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public interface Message {

    /**
     * Description:返回Message的类型
     */
    Class<? extends Message> getType();

}
