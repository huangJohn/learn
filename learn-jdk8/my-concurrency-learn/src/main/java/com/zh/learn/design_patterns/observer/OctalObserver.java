package com.zh.learn.design_patterns.observer;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getStatus()));
    }
}
