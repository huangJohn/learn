package com.zh.learn.concurrency_test.design.event_driven;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public interface Message {

    /**
     * 返回Message的类型，看作消息事件
     */
    Class<? extends Message> getType();

}
