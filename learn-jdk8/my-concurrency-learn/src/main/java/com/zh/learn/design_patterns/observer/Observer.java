package com.zh.learn.design_patterns.observer;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    protected abstract void update();

}
