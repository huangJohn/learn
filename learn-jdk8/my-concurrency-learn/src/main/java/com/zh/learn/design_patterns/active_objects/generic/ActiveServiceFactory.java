package com.zh.learn.design_patterns.active_objects.generic;

import com.zh.learn.design_patterns.active_objects.standard.ActiveFuture;
import com.zh.learn.design_patterns.active_objects.standard.ActiveMessageQueue;
import com.zh.learn.design_patterns.future.Future;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public class ActiveServiceFactory {

    private static final ActiveMessageGenericQueue queue = new ActiveMessageGenericQueue();

    public static <T> T active(T instance) {
        Object proxyInstance = Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), new ActiveInvocationHandler<>(instance));
        return (T) proxyInstance;
    }

    private static class ActiveInvocationHandler<T> implements InvocationHandler {

        private final T instance;

        public ActiveInvocationHandler(T instance) {
            this.instance = instance;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.isAnnotationPresent(ActiveMethod.class)) {
                this.checkMethod(method);
                ActiveMessage.Builder builder = new ActiveMessage.Builder();
                builder.userMethod(method).withObjects(args).forService(instance);
                Object result = null;
                if (this.isReturnFutureType(method)) {
                    result = new ActiveFuture<>();
                    builder.returnFuture((ActiveFuture) result);
                }
                queue.offer(builder.build());
                return result;
            } else {
                return method.invoke(instance, args);
            }
        }

        private void checkMethod(Method method) throws IllegalActiveMethod {
            if (!isReturnFutureType(method)) {
                throw new IllegalActiveMethod("the method [ " + method.getName() + " ] return type must be Void/Future");
            }
        }

        private boolean isReturnFutureType(Method method) {
            return method.getReturnType().isAssignableFrom(Future.class);
        }
    }


}
