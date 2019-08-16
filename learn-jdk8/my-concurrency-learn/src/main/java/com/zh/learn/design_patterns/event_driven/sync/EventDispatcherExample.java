package com.zh.learn.design_patterns.event_driven.sync;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-16
 */
public class EventDispatcherExample {

    public static class InputEvent extends Event {
        private final int x;
        private final int y;

        public InputEvent(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static class ResultEvent extends Event {
        private final int result;

        public ResultEvent(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }
    }

    public  static class ResultEventHandler implements Channel<ResultEvent> {
        @Override
        public void dispatch(ResultEvent message) {
            System.out.println("the result is : " + message.getResult());
        }
    }

    public static class InputEventHandler implements Channel<InputEvent> {

        private final EventDispatcher dispatcher;

        InputEventHandler(EventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        @Override
        public void dispatch(InputEvent message) {
            System.out.printf("x=%d, y=%d\n", message.getX(), message.getY());
            int result = message.getX() + message.getY();
            dispatcher.dispatch(new ResultEvent(result));
        }
    }

    public static void main(String[] args) {

        EventDispatcher eventDispatcher = new EventDispatcher();
        eventDispatcher.registerChannel(InputEvent.class, new InputEventHandler(eventDispatcher));
        eventDispatcher.registerChannel(ResultEvent.class, new ResultEventHandler());
        eventDispatcher.dispatch(new InputEvent(1, 2));
    }




}
