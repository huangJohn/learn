package com.zh.learn.design_patterns.event_driven.chat_application;

import com.zh.learn.design_patterns.event_driven.async.AsyncEventDispatcher;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-17
 */
public class UserChatThread extends Thread {

    private final User user;
    private final AsyncEventDispatcher dispatcher;

    public UserChatThread(User user, AsyncEventDispatcher dispatcher) {
        super(user.getName());
        this.user = user;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        dispatcher.dispatch(new UserOnlineEvent(user));
        for (int i = 0; i < 5; i++) {
            dispatcher.dispatch(new UserChatEvent(user, getName() + "-hello-" + i));
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dispatcher.dispatch(new UserOfflineEvent(user));
    }
}
