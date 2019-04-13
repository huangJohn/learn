package com.zh.learn.concurrency_test.design.event_driven;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public interface DynamicRouter<E extends Message> {

    /**
     * 如何分配message到channel上
     */

    /**
     * 对每一种Message类型注册相关的Channel，只有找到合适的Channel，该Messsage才会被处理
     */
    void registerChannel(Class<? extends Message> messageType, Channel<? extends E> channel);

    /**
     * 为相应的Channel分配Message
     */
    void dispatch(E message);
}