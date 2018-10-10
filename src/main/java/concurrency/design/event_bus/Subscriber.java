package concurrency.design.event_bus;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class Subscriber {

    private final Object subscribeObject;

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
