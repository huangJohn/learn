package com.zh.learn.concurrency_test.design.event_driven.usage;

import com.zh.learn.concurrency_test.design.event_driven.Event;
import com.zh.learn.concurrency_test.design.event_driven.async_eda.AsyncChannel;

/**
 * @author zhuanghuang
 * @date 2018/10/12
 */

public class UserOnlineEventChannel extends AsyncChannel {

    @Override
    protected void handle(Event message) {

        UserOnlineEvent event = (UserOnlineEvent) message;
        System.out.println("the User=[" + event.getUser().getName() + "] is online");
    }
}
