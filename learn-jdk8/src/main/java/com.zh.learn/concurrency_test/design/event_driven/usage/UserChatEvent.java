package com.zh.learn.concurrency_test.design.event_driven.usage;

/**
 * @author zhuanghuang
 * @date 2018/10/12
 */

public class UserChatEvent extends UserOnlineEvent {

    //聊天信息
    private final String message;

    public UserChatEvent(User user, String message) {
        super(user);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
