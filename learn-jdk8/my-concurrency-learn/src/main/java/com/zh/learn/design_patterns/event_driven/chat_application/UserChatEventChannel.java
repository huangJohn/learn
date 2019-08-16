package com.zh.learn.design_patterns.event_driven.chat_application;

import com.zh.learn.design_patterns.event_driven.async.AsyChannel;
import com.zh.learn.design_patterns.event_driven.sync.Event;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-17
 */
public class UserChatEventChannel extends AsyChannel {

    @Override
    protected void handler(Event message) {

        UserChatEvent userChatEvent = (UserChatEvent) message;
        System.out.println("the user [ " + userChatEvent.getUser().getName() + " ] say: " + userChatEvent.getMsg());
    }
}
