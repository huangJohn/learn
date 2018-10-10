package concurrency.design.event_bus;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class Registry {

    //存储Subscriber集合和topic之间关系的map
    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Subscriber>> subscriberContainer = new ConcurrentHashMap<>();

    public void bind(Object subscriber) {

        //获取Subscriber Object的方法集合然后进行绑定
        List<Method> subscriberMethods = getSubscriberMethods(subscriber);
        subscriberMethods.forEach(method -> {
            tierSubscriber(subscriber, method);
        });
    }

    private void tierSubscriber(Object subscriber, Method method) {

        final Subscribe subscribe = method.getDeclaredAnnotation(Subscribe.class);
        String topic = subscribe.topic();
        //当某topic没有Subscriber Queue时创建一个
        subscriberContainer.computeIfAbsent(topic, key -> new ConcurrentLinkedQueue<>());
        //创建一个Subscriber并且加入Subscriber列表中
        subscriberContainer.get(topic).add(new Subscriber(subscriber, method));

    }

    private List<Method> getSubscriberMethods(Object subscriber) {
        final List<Method> methods = new ArrayList<>();
        Class<?> tmp = subscriber.getClass();
        //不断获取当前类和父类的所有@Subscribe方法
        while (null != tmp) {
            Method[] declaredMethods = tmp.getDeclaredMethods();
            //只有public方法，并且有一个入参，被@Subscribe注解标记过的方法才符合回调方法
            Arrays.stream(declaredMethods)
                    .filter(m -> m.isAnnotationPresent(Subscribe.class) && m.getParameterCount() == 1 && m.getModifiers() == Modifier.PUBLIC)
                    .forEach(methods::add);
            tmp = tmp.getSuperclass();
        }
        return methods;
    }

    public void unbind(Object subscriber) {

        //解除注册为提高速度，只对Subscriber进行失效操作
        subscriberContainer.forEach((key,queue)->{
            queue.forEach(s->{
                if (s.getSubscriberObject() == subscriber) {
                    s.setDisable(true);
                }
            });
        });
    }

    public ConcurrentLinkedQueue<Subscriber> scanSubscriber(final String topic) {

        return subscriberContainer.get(topic);
    }
}
