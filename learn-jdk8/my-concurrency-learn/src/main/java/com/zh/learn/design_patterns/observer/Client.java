package com.zh.learn.design_patterns.observer;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public class Client {

    public static void main(String[] args) {

        final Subject subject = new Subject();
        Observer observer1 = new BinaryObserver(subject);
        Observer observer2 = new OctalObserver(subject);
        subject.setStatus(1);
        System.out.println("==========");
        subject.setStatus(2);
        System.out.println("===========");
        subject.setStatus(2);
        System.out.println("===========");

    }

}
