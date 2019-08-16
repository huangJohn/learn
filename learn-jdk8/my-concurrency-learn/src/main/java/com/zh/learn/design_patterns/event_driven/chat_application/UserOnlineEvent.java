package com.zh.learn.design_patterns.event_driven.chat_application;

import com.zh.learn.design_patterns.event_driven.sync.Event;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
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
