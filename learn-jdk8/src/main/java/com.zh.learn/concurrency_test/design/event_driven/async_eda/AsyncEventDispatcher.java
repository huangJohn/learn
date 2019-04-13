package com.zh.learn.concurrency_test.design.event_driven.async_eda;

import com.zh.learn.concurrency_test.design.event_driven.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public class AsyncEventDispatcher implements DynamicRouter<Event> {

    private final Map<Class<? extends Message>, AsyncChannel> routerTable;

    public AsyncEventDispatcher() {
        this.routerTable = new ConcurrentHashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Message> messageType, Channel<? extends Event> channel) {

        if (!(channel instanceof AsyncChannel)) {
            throw new IllegalArgumentException("the channel must be AsyncChannel Type");
        }
        this.routerTable.put(messageType, (AsyncChannel) channel);
    }

    @Override
    public void dispatch(Event message) {

        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("can't match channel for Message-[" + message.getType() + "] type");
        }
    }

    public void shutDown() {
        routerTable.values().forEach(AsyncChannel::stop);
    }
}
