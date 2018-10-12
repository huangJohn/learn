package concurrency.design.event_driven.usage;

import concurrency.design.event_driven.async_eda.AsyncEventDispatcher;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author zhuanghuang
 * @date 2018/10/12
 */

public class UserChatThread extends Thread {

    private final User user;
    private final AsyncEventDispatcher dispatcher;

    public UserChatThread(User user, AsyncEventDispatcher dispatcher) {
        this.user = user;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {

        //用户上线
        dispatcher.dispatch(new UserOnlineEvent(user));
        for (int i = 0; i < 5; i++) {

            try {
                //用户发消息
                dispatcher.dispatch(new UserChatEvent(user, user.getName() + " -> hello-" + i));
                TimeUnit.SECONDS.sleep(current().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //用户下线
                dispatcher.dispatch(new UserOfflineEvent(user));
            }
        }


    }
}
