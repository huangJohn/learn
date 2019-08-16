package com.zh.learn.design_patterns.event_driven.chat_application;

import com.zh.learn.design_patterns.event_driven.async.AsyncEventDispatcher;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-17
 */
public class UserChatApplication {

    public static void main(String[] args) {

        final AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();
        dispatcher.registerChannel(UserOnlineEvent.class, new UserOnlineEventChannel());
        dispatcher.registerChannel(UserChatEvent.class, new UserChatEventChannel());
        dispatcher.registerChannel(UserOfflineEvent.class, new UserOfflineEventChannel());

        new UserChatThread(new User("abc"), dispatcher).start();
        new UserChatThread(new User("leo"), dispatcher).start();
        new UserChatThread(new User("david"), dispatcher).start();
        new UserChatThread(new User("tony"), dispatcher).start();

    }

}
