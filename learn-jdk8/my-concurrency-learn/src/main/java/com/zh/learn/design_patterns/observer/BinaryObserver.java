package com.zh.learn.design_patterns.observer;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }


    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getStatus()));
    }
}
