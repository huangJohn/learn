package concurrency.design.event_bus.watch_service;

import concurrency.design.event_bus.AsyncEventBus;
import concurrency.design.event_bus.EventBus;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public class Client {
    public static void main(String[] args) throws IOException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        final EventBus eventBus = new AsyncEventBus(executor);
        //register
        eventBus.register(new FileChangeListener());
        DirectoryTargetMonitor monitor = new DirectoryTargetMonitor(eventBus, "monitor");
        monitor.startMonitor();

    }
}
