package com.zh.learn.design_patterns.event_driven.sync;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public interface Channel<E extends Message> {

    /**
     * Description:负责message的调度
     */
    void dispatch(E message);

}
