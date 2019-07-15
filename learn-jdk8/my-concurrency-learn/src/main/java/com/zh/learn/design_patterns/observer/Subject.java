package com.zh.learn.design_patterns.observer;

import com.zh.learn.design_patterns.thread_observable.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {

        if (this.status == status) {
            return;
        }

        this.status = status;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {

        observers.stream().forEach(Observer::update);
    }
}
