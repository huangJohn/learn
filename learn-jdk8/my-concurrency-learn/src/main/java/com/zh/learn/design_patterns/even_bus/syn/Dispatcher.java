package com.zh.learn.design_patterns.even_bus.syn;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public class Dispatcher {

    private final Executor executorService;
    private final EventExceptionHandler eventExceptionHandler;

    public static final Executor SEQ_EXECUTOR_SERVICE = SeqExecutorService.Instance;
    public static final Executor PER_THREAD_EXECUTOR_SERVICE = PerThreadExecutorService.Instance;

    public Dispatcher(EventExceptionHandler eventExceptionHandler, Executor executor) {
        this.eventExceptionHandler = eventExceptionHandler;
        this.executorService = executor;
    }

    public void dispatch(EventBus eventBus, Registry registry, Object event, String topic) {

        //根据topic拿到所有Subscriber集合
        ConcurrentLinkedDeque<Subscriber> subscribers = registry.scanSubscriber(topic);
        if (null == subscribers) {
            if (eventExceptionHandler != null) {
                eventExceptionHandler.handle(new IllegalArgumentException("the topic = " + topic + " is not bind yet"), new BaseEventContext(eventBus.getBusName(), null, event));
                return;
            }
        }

        subscribers.stream().filter(subscriber -> !subscriber.isDisable())
                .filter(subscriber -> {
                    Method subscriberMethod = subscriber.getSubscriberMethod();
                    Class<?> parameterType = subscriberMethod.getParameterTypes()[0];
                    return (parameterType.isAssignableFrom(event.getClass()));
                })
                .forEach(subscriber -> {
                    realInvokeSubscribe(subscriber, event, eventBus);
                });
    }

    private void realInvokeSubscribe(Subscriber subscriber, Object event, EventBus eventBus) {
        Method subscriberMethod = subscriber.getSubscriberMethod();
        Object subscriberObj = subscriber.getSubscriber();
        executorService.execute(() -> {
            try {
                subscriberMethod.invoke(subscriberObj, event);
            } catch (Exception e) {
                if (null != eventExceptionHandler) {
                    eventExceptionHandler.handle(e, new BaseEventContext(eventBus.getBusName(), subscriber, event));
                }
            }
        });
    }

    public void close() {
        if (executorService instanceof ExecutorService) {
            ((ExecutorService) executorService).shutdown();
        }
    }

    static Dispatcher newDispatcher(EventExceptionHandler eventExceptionHandler, Executor executor) {
        return new Dispatcher(eventExceptionHandler, executor);
    }

    static Dispatcher seqDispatcher(EventExceptionHandler eventExceptionHandler) {
        return new Dispatcher(eventExceptionHandler, SEQ_EXECUTOR_SERVICE);
    }

    static Dispatcher perThreadDispatcher(EventExceptionHandler eventExceptionHandler) {
        return new Dispatcher(eventExceptionHandler, PER_THREAD_EXECUTOR_SERVICE);
    }

    private static class SeqExecutorService implements Executor {

        private final static SeqExecutorService Instance = new SeqExecutorService();

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    private static class PerThreadExecutorService implements Executor {

        private final static PerThreadExecutorService Instance = new PerThreadExecutorService();

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

    private static class BaseEventContext implements EventContext {

        private final String eventBusName;
        private final Subscriber subscriber;
        private final Object event;

        private BaseEventContext(String eventBusName, Subscriber subscriber, Object event) {
            this.eventBusName = eventBusName;
            this.subscriber = subscriber;
            this.event = event;
        }

        @Override
        public String getSource() {
            return this.eventBusName;
        }

        @Override
        public Object getSubscriber() {
            return this.subscriber != null ? subscriber.getSubscriber() : null;
        }

        @Override
        public Method getSubscribe() {
            return this.subscriber != null ? subscriber.getSubscriberMethod() : null;
        }

        @Override
        public Object getEvent() {
            return this.event;
        }
    }


}
