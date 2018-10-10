package concurrency.design.event_bus;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class SimpleSubscriber1 {

    @Subscribe
    public void method1(String msg) {
        System.out.println("====SimpleSubscriber1====method1==" + msg);
    }

    @Subscribe(topic = "test")
    public void method2(String msg) {
        System.out.println("====SimpleSubscriber1====method2==" + msg);
    }
}
