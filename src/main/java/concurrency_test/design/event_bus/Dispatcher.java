package concurrency_test.design.event_bus;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class Dispatcher {

    private final Executor executorService;

    private final EventExceptionHandler exceptionHandler;

    /**
     * 同步dispatcher
     */
    public static final Executor SEQ_EXECUTOR_SERVICE = SeqExecutorService.INSTANCE;

    /**
     * 并发dispatcher
     */
    public static final Executor PER_THREAD_EXECUTOR_SERVICE = PerThreadExecutorService.INSTANCE;

    private Dispatcher(Executor executorService, EventExceptionHandler exceptionHandler) {
        this.executorService = executorService;
        this.exceptionHandler = exceptionHandler;
    }

    public static Dispatcher newDispatcher(EventExceptionHandler exceptionHandler, Executor executor) {
        return new Dispatcher(executor, exceptionHandler);
    }

    /**
     * 默认同步构造
     */
    public static Dispatcher seqDispatcher(EventExceptionHandler exceptionHandler) {
        return new Dispatcher(SEQ_EXECUTOR_SERVICE, exceptionHandler);
    }

    /**
     * 默认并发构造
     */
    public static Dispatcher perThreadDispatche(EventExceptionHandler exceptionHandler) {
        return new Dispatcher(PER_THREAD_EXECUTOR_SERVICE, exceptionHandler);
    }

    public void dispatch(Bus bus, Registry registry, Object event, String topic) {

        //根据topic获取所有的Subscriber列表
        ConcurrentLinkedQueue<Subscriber> subscribers = registry.scanSubscriber(topic);
        if (null == subscribers) {
            if (null != exceptionHandler) {
                exceptionHandler.handle(new IllegalArgumentException("the topic-" + topic + " is not bind yet"),
                        new BaseEventContext(bus.getBusName(), null, event));
            }
            return;
        }

        //遍历所有方法，通过反射进行方法调用
        subscribers.stream()
                .filter(subscriber -> !subscriber.isDisable())//过滤失效的
                .filter(subscriber -> {
                    Method subscribeMethod = subscriber.getSubscribeMethod();//得到订阅的方法
                    Class<?> aClass = subscribeMethod.getParameterTypes()[0];//得到订阅方法的参数类型Class
                    return (aClass.isAssignableFrom(event.getClass()));//得到订阅的方法参数类型和event的类型相同的、或者具有父子关系的
                })//过滤
                .forEach(subscriber -> realInvokeSubscribe(subscriber, event, bus));
    }

    private void realInvokeSubscribe(Subscriber subscriber, Object event, Bus bus) {

        Method subscribeMethod = subscriber.getSubscribeMethod();
        Object subscriberObject = subscriber.getSubscriberObject();
        executorService.execute(()->{
            try {
                subscribeMethod.invoke(subscriberObject, event);
            } catch (Exception e) {
                if (null != exceptionHandler) {
                    exceptionHandler.handle(e, new BaseEventContext(bus.getBusName(), subscriber, event));
                }
            }
        });
    }

    public void close() {

        if (executorService instanceof ExecutorService) {
            ((ExecutorService) executorService).shutdown();
        }
    }

    /**
     * 顺序执行的executorService，同步
     */
    private static class SeqExecutorService implements Executor {

        private final static SeqExecutorService INSTANCE = new SeqExecutorService();

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    /**
     * 每个线程负责一次消息推送，并发多线程
     */
    private static class PerThreadExecutorService implements Executor {

        private final static PerThreadExecutorService INSTANCE = new PerThreadExecutorService();

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

    /**
     * 默认的EventContext实现
     */
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
            return eventBusName;
        }

        @Override
        public Object getSubscriber() {
            return subscriber != null ? subscriber.getSubscriberObject() : null;
        }

        @Override
        public Method getSubscribe() {
            return subscriber != null ? subscriber.getSubscribeMethod() : null;
        }

        @Override
        public Object getEvent() {
            return event;
        }
    }



}
