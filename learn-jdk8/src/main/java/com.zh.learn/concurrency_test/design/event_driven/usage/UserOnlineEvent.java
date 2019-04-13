package com.zh.learn.concurrency_test.design.event_driven.usage;

import com.zh.learn.concurrency_test.design.event_driven.Event;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public class UserOnlineEvent extends Event {

    private final User user;

    public UserOnlineEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
