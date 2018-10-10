package concurrency.design.event_bus;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class SimpleSubscriber2 {

    @Subscribe
    public void method1(String msg) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("====SimpleSubscriber2====method1==" + msg);
    }

    @Subscribe(topic = "test")
    public void method2(String msg) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("====SimpleSubscriber2====method2==" + msg);
    }
}
