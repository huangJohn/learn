package com.zh.learn.design_patterns.event_driven.chat_application;

import com.zh.learn.design_patterns.event_driven.async.AsyChannel;
import com.zh.learn.design_patterns.event_driven.sync.Event;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class UserOnlineEventChannel extends AsyChannel {

    @Override
    protected void handler(Event message) {
        UserOnlineEvent userOnlineEvent = (UserOnlineEvent) message;
        System.out.println(" the user [ " + userOnlineEvent.getUser().getName() + " ] is online");
    }
}
