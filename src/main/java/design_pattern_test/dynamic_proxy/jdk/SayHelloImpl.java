package design_pattern_test.dynamic_proxy.jdk;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 */

public class SayHelloImpl implements SayHello {

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
