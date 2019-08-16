package com.zh.learn.design_patterns.event_driven.async;

import com.zh.learn.design_patterns.event_driven.sync.Channel;
import com.zh.learn.design_patterns.event_driven.sync.DynamicRouter;
import com.zh.learn.design_patterns.event_driven.sync.Event;
import com.zh.learn.design_patterns.event_driven.sync.MessageMatcherException;
import sun.nio.ch.ChannelInputStream;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class AsyncEventDispatcher implements DynamicRouter<Event> {

    private final Map<Class<? extends Event>, AsyChannel> routerTable;

    public AsyncEventDispatcher() {
        this.routerTable = new ConcurrentHashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Event> messageType, Channel<? extends Event> channel) {
        if (!(channel instanceof AsyChannel)) {
            throw new IllegalArgumentException("the channel must be AsyChannel type");
        }
        this.routerTable.put(messageType, (AsyChannel) channel);
    }

    @Override
    public void dispatch(Event message) throws MessageMatcherException {
        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException(" can not match the channel for [ " + message.getType() + " ] type");
        }
    }

    public void shutDown() {
        routerTable.values().forEach(AsyChannel::stop);
    }
}
