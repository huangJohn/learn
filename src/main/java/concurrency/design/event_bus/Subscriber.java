package concurrency.design.event_bus;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

/**
 * 订阅者对象
 */
public class Subscriber {

    /**
     * 对象
     */
    private final Object subscribeObject;

    /**
     * 触发的方法
     */
    private final Method subscribeMethod;

    private boolean disable = false;

    public Subscriber(Object subscribeObject, Method subscribeMethod) {

        this.subscribeObject = subscribeObject;
        this.subscribeMethod = subscribeMethod;
    }

    public Object getSubscriberObject() {
        return this.subscribeObject;
    }

    public Method getSubscribeMethod() {
        return this.subscribeMethod;
    }

    public boolean isDisable() {
        return this.disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
