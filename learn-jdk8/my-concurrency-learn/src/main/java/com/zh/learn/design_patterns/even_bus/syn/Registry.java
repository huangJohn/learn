package com.zh.learn.design_patterns.even_bus.syn;

import com.zh.learn.design_patterns.even_bus.Subscribe;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
class Registry {

    //topic和Subscriber的mapping
    private final ConcurrentHashMap<String, ConcurrentLinkedDeque<Subscriber>> subscriberContainer = new ConcurrentHashMap<>();

    public void bind(Object subscriber) {
        //获取Subscriber obj的方法集合
        List<Method> subscribeMethods = getSubscribeMethod(subscriber);
        //绑定
        subscribeMethods.forEach(m -> {
            tieSubscriber(subscriber, m);
        });
    }

    public ConcurrentLinkedDeque<Subscriber> scanSubscriber(String topic) {
        return subscriberContainer.get(topic);
    }

    private void tieSubscriber(Object subscriber, Method method) {

        //获取到topic
        Subscribe subscribe = method.getDeclaredAnnotation(Subscribe.class);
        String topic = subscribe.topic();
        //没有新建
        subscriberContainer.computeIfAbsent(topic, key -> {
            return new ConcurrentLinkedDeque<Subscriber>();
        });
        //tie
        subscriberContainer.get(topic).add(new Subscriber(subscriber, method));
    }

    private List<Method> getSubscribeMethod(Object subscriber) {
        List<Method> methods = new ArrayList<>();
        Class<?> temp = subscriber.getClass();
        while (temp != null) {
            Method[] declaredMethods = temp.getDeclaredMethods();
            Arrays.stream(declaredMethods).filter(m -> m.isAnnotationPresent(Subscribe.class)
                    && m.getParameterCount() == 1 && m.getModifiers() == Modifier.PUBLIC)
                    .forEach(methods::add);
            //向上查找父类的
            temp = temp.getSuperclass();
        }
        return methods;
    }

    public void unBind(Object subscriber) {
        subscriberContainer.forEach((key, queue) -> {
            queue.forEach(s -> {
                //queue中subscriber == 入参subscriber,置无效
                if (s.getSubscriber() == subscriber) {
                    s.setDisable(true);
                }
            });
        });
    }
}
