package com.zh.learn.design_patterns.event_driven.async;

import com.zh.learn.design_patterns.event_driven.sync.Event;
import com.zh.learn.design_patterns.event_driven.sync.EventDispatcherExample;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class AsyncEventDispatcherExample {

    static class AsyncInputEventHandler extends AsyChannel {

        private final AsyncEventDispatcher asyncEventDispatcher;

        AsyncInputEventHandler(AsyncEventDispatcher asyncEventDispatcher) {
            this.asyncEventDispatcher = asyncEventDispatcher;
        }

        @Override
        protected void handler(Event message) {
            EventDispatcherExample.InputEvent inputEvent = (EventDispatcherExample.InputEvent) message;
            System.out.printf("x=%d, y=%d\n", inputEvent.getX(), inputEvent.getY());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int result = inputEvent.getX() + inputEvent.getY();
            asyncEventDispatcher.dispatch(new EventDispatcherExample.ResultEvent(result));
        }
    }

    static class AsyncResultEventHandler extends AsyChannel {

        @Override
        protected void handler(Event message) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the result is : " + ((EventDispatcherExample.ResultEvent) message).getResult());
        }
    }

    public static void main(String[] args) {

        AsyncEventDispatcher asyncEventDispatcher = new AsyncEventDispatcher();
        asyncEventDispatcher.registerChannel(EventDispatcherExample.InputEvent.class, new AsyncInputEventHandler(asyncEventDispatcher));
        asyncEventDispatcher.registerChannel(EventDispatcherExample.ResultEvent.class, new AsyncResultEventHandler());
        asyncEventDispatcher.dispatch(new EventDispatcherExample.InputEvent(1, 2));
        asyncEventDispatcher.dispatch(new EventDispatcherExample.InputEvent(5, 6));
//        asyncEventDispatcher.shutDown();
    }


}
