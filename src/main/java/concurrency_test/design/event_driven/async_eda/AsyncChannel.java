package concurrency_test.design.event_driven.async_eda;

import concurrency_test.design.event_driven.Channel;
import concurrency_test.design.event_driven.Event;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public abstract class AsyncChannel implements Channel<Event> {

    //在AsyncChannel中使用ExecutorService多线程的方式提交Message
    private final ExecutorService executorService;

    //默认构造
    public AsyncChannel() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }

    //用户自定义ExecutorService
    public AsyncChannel(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public final void dispatch(Event message) {
        executorService.submit(() -> this.handle(message));
    }

    //供子类具体实现处理Message
    protected abstract void handle(Event message);

    public void stop() {
        if (null != executorService && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}