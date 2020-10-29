package com.zh.learn.bean.circle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/17
 */
@Component
public class BeanTestC implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        if (beanName.equals("beanTestA")) {
//            return new CGLIBProxy(bean).createProxy();
//        }
        return bean;
    }


    private static class CGLIBProxy implements MethodInterceptor {

        private Object obj;

        public CGLIBProxy(Object obj) {
            this.obj = obj;
        }

        public Object createProxy() {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(obj.getClass());
            enhancer.setCallback(new CGLIBProxy(obj));
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("----" + method.getName() + "方法开始----");
            Object res = method.invoke(obj, objects);
            System.out.println("----" + method.getName() + "方法结束----");
            return res;
        }
    }
}
