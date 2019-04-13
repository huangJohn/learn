package com.zh.learn.concurrency_test.design.event_driven.usage;

/**
 * @author zhuanghuang
 * @date 2018/10/12
 */

public class UserOfflineEvent extends UserOnlineEvent {

    public UserOfflineEvent(User user) {
        super(user);
    }
}
