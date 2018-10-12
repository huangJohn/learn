package concurrency.design.event_driven.usage;

import concurrency.design.event_driven.Event;
import concurrency.design.event_driven.async_eda.AsyncChannel;

/**
 * @author zhuanghuang
 * @date 2018/10/12
 */

public class UserChatEventChannel extends AsyncChannel {
    @Override
    protected void handle(Event message) {
        UserChatEvent event = (UserChatEvent) message;
        System.out.println("the User-[" + event.getUser().getName() + "] say: " + event.getMessage());
    }
}
