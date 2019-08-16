package com.zh.learn.design_patterns.event_driven.chat_application;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class UserOfflineEvent extends UserOnlineEvent {


    public UserOfflineEvent(User user) {
        super(user);
    }
}
