package design_pattern_test.dynamic_proxy.jdk;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 */

public class Client {
    public static void main(String[] args) {

        SayHello sayHello = new SayHelloImpl();
        SayHello bind = (SayHello) new JdkSayHelloProxy().bind(sayHello);
        bind.sayHello();
    }
}
