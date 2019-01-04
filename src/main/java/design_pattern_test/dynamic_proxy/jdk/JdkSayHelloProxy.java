package design_pattern_test.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 *
 * jdk接口动态代理
 */

public class JdkSayHelloProxy implements InvocationHandler {

    private Object target = null;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("调用之前");
        Object result = method.invoke(target, args);
        System.out.println("调用之后");
        return result;
    }

}
