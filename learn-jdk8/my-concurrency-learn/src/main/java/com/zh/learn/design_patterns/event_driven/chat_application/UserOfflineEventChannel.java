package com.zh.learn.design_patterns.event_driven.chat_application;

import com.zh.learn.design_patterns.event_driven.async.AsyChannel;
import com.zh.learn.design_patterns.event_driven.sync.Event;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class UserOfflineEventChannel extends AsyChannel {

    @Override
    protected void handler(Event message) {
        UserOfflineEvent userOfflineEvent = (UserOfflineEvent) message;
        System.out.println(" the user [ " + userOfflineEvent.getUser().getName() + " ] is offline");

    }
}
