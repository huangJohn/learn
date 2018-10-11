package concurrency.design.event_bus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class Client {

    public static void main(String[] args) {

        Bus bus = new EventBus("test-bus");
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("hello");
        System.out.println("------------------");
        bus.post("www", "test");

        bus = new AsyncEventBus("async-test-bus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        bus.register(new SimpleSubscriber1());
        bus.register(new SimpleSubscriber2());
        bus.post("he");
        System.out.println("------------------");
        bus.post("ww", "test");

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
