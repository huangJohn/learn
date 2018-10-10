package concurrency.design.event_bus;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class SimpleSubscriber2 {

    @Subscribe
    public void method1(String msg) {
        System.out.println("====SimpleSubscriber2====method1==" + msg);
    }

    @Subscribe(topic = "test")
    public void method2(String msg) {
        System.out.println("====SimpleSubscriber2====method2==" + msg);
    }
}
