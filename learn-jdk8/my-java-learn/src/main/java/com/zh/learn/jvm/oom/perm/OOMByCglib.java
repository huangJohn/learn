package com.zh.learn.jvm.oom.perm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 * 方法区存储class相关的信息，比如类名，访问修饰符，常量池，字段描述，方法描述等
 * 通过cglib动态增强创造类使之oom
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/21
 */
public class OOMByCglib {

    public static void main(String[] args) {


        while (true) {


            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObj.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, args);
                }
            });
            enhancer.create();

        }
    }

    public static class OOMObj {
    }


}
