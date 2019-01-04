package concurrency_test.design.event_bus;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public interface EventExceptionHandler {
    void handle(Throwable cause, EventContext context);
}
