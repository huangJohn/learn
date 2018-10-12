package concurrency.design.event_driven.usage;

import concurrency.design.event_driven.Event;
import concurrency.design.event_driven.async_eda.AsyncChannel;

/**
 * @author zhuanghuang
 * @date 2018/10/12
 */

public class UserOfflineEventChannel extends AsyncChannel {
    @Override
    protected void handle(Event message) {
        UserOfflineEvent event = (UserOfflineEvent) message;
        System.out.println("the User-[" + event.getUser().getName() + "] is offline");
    }
}
