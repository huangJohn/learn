package com.zh.learn.design_patterns.event_driven.sync;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public interface DynamicRouter<E extends Message> {

    /**
     * Description:对每一种类型的message，找到合适的channel，该message才会被处理
     */
    void registerChannel(Class<? extends E> messageType, Channel<? extends E> channel);

    /**
     * Description:为响应的channerl分配message```````````
     */
    void dispatch(E message) throws MessageMatcherException;

}
