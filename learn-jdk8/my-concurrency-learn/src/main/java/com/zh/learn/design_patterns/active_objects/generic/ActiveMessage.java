package com.zh.learn.design_patterns.active_objects.generic;

import com.zh.learn.design_patterns.active_objects.standard.ActiveFuture;
import com.zh.learn.design_patterns.future.Future;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public class ActiveMessage {

    //接口方法的参数
    private final Object[] objects;

    //接口方法
    private final Method method;

    //有返回值的方法，会返回ActiveFuture<Object>类型
    private final ActiveFuture<Object> future;

    //具体接口
    private final Object service;


    public ActiveMessage(Builder builder) {
        this.objects = builder.objects;
        this.method = builder.method;
        this.future = builder.future;
        this.service = builder.service;
    }

    //将ActiveMessage的方法通过反射的方式调用执行的具体实现
    public void execute() {
        try {
            Object result = method.invoke(service, objects);
            if (future != null) {
                //如果有返回值的接口方法，需要通过get方法获得最终的结果
                Future<?> realFuture = (Future<?>) result;
                Object realResult = realFuture.get();
                future.finish(realResult);
            }
        } catch (Exception e) {
            //异常，显示置为null
            if (future != null) {
                future.finish(null);
            }
        }
    }

    static class Builder {
        public Object[] objects;
        public Method method;
        public ActiveFuture<Object> future;
        public Object service;

        public Builder userMethod(Method method) {
            this.method = method;
            return this;
        }

        public Builder returnFuture(ActiveFuture<Object> future) {
            this.future = future;
            return this;
        }

        public Builder withObjects(Object[] objects) {
            this.objects = objects;
            return this;
        }

        public Builder forService(Object service) {
            this.service = service;
            return this;
        }

        public ActiveMessage build() {
            return new ActiveMessage(this);
        }
    }

}
