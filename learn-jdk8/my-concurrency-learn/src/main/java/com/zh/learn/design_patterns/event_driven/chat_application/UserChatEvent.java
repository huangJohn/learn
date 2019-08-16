package com.zh.learn.design_patterns.event_driven.chat_application;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class UserChatEvent extends UserOnlineEvent {

    private final String msg;

    public UserChatEvent(User user, String msg) {
        super(user);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
