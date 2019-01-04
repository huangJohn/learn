package concurrency_test.design.event_driven.usage;

import concurrency_test.design.event_driven.async_eda.AsyncEventDispatcher;

/**
 * @author zhuanghuang
 * @date 2018/10/12
 */

public class UserChatApplication {

    public static void main(String[] args) {

        final AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();
        dispatcher.registerChannel(UserOnlineEvent.class, new UserOnlineEventChannel());
        dispatcher.registerChannel(UserChatEvent.class, new UserChatEventChannel());
        dispatcher.registerChannel(UserOfflineEvent.class, new UserOfflineEventChannel());

        new UserChatThread(new User("leo"), dispatcher).start();
        new UserChatThread(new User("alex"), dispatcher).start();
        new UserChatThread(new User("david"), dispatcher).start();
    }
}
