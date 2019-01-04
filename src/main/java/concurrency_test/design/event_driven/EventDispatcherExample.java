package concurrency_test.design.event_driven;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public class EventDispatcherExample {

    /**
     * InputEvent中定义了两个属性X和Y，主要用于在其他Channel中的运算
     */
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

    /**
     * 用于存放结果的Event
     */
    public static class ResultEvent extends Event {

        private final int result;

        public ResultEvent(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }

    }

    /**
     * 处理ResultEvent的Handler（Channel），只是简单得将计算结果输出到控制台
     */
    static class ResultEventHandler implements Channel<ResultEvent> {

        @Override
        public void dispatch(ResultEvent message) {
            System.out.printf("the result is: %d", message.getResult());
        }
    }

    /**
     * InputEventHandler需要向Router发送Event，因此构造时传入Dispatcher
     */
    static class InputEventHandler implements Channel<InputEvent> {

        private final EventDispatcher dispatcher;

        public InputEventHandler(EventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        /**
         * 将计算结果构造新的Event提交给Router
         */
        @Override
        public void dispatch(InputEvent message) {

            System.out.printf("X: %d, Y: %d\n", message.getX(), message.getY());
            int result = message.getX() + message.getY();
            dispatcher.dispatch(new ResultEvent(result));
        }
    }

    public static void main(String[] args) {

        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(InputEvent.class, new InputEventHandler(dispatcher));
        dispatcher.registerChannel(ResultEvent.class, new ResultEventHandler());
        dispatcher.dispatch(new InputEvent(1, 2));
    }


}
