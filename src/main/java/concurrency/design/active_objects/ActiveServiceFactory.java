package concurrency.design.active_objects;

import concurrency.design.future.Future;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class ActiveServiceFactory {

    //定义ActiveMessageQueue，存放ActiveMessage
    private final static ActiveMessageQueue ACTIVE_MESSAGE_QUEUE = new ActiveMessageQueue();

    public static <T> T active(T instance) {

        //生成Service的代理类
        Object proxy = Proxy.newProxyInstance(instance.getClass().getClassLoader(), instance.getClass().getInterfaces(), new ActiveInvocationHandler<>(instance));
        return (T) proxy;
    }

    //ActiveInvocationHandler是InvocationHandler的子类，生成Proxy时需要使用到
    private static class ActiveInvocationHandler<T> implements InvocationHandler {

        private final T instance;

        ActiveInvocationHandler(T instance) {
            this.instance = instance;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            //如果接口方法被@ActiveMessage注解标记过，则会转换为ActiveMessage
            if (method.isAnnotationPresent(ActiveMethod.class)) {

                //检查该方法是否符合规范
                this.checkMethod(method);
                ActiveMessage.Builder builder = new ActiveMessage.Builder();
                builder.useMethod(method).withObjects(args).forService(instance);
                Object result = null;
                if (this.isReturnFutureType(method)) {
                    result = new ActiveFuture<>();
                    builder.returnFuture((ActiveFuture) result);
                }
                //将ActiveMessage加入至队列中
                ACTIVE_MESSAGE_QUEUE.offer(builder.build());
                return result;
            } else {
                //普通方法
                return method.invoke(instance, args);
            }
        }

        //检查有返回值的方法是否返回类型为Future，否则抛出异常
        //自定义的IllegalActiveMethod异常
        private void checkMethod(Method method) throws IllegalActiveMethodException {
            if (!isReturnVoidType(method) && !isReturnFutureType(method)) {
                throw new IllegalActiveMethodException("the method [" + method.getName() + "] return type must be Void or Future type");
            }
        }

        //判断接口方法是否为Future返回类型
        private boolean isReturnFutureType(Method method) {
            return method.getReturnType().isAssignableFrom(Future.class);
        }

        //判断接口方法是否返回空类类型
        private boolean isReturnVoidType(Method method) {
            return method.getReturnType().equals(Void.TYPE);
        }
    }

}
