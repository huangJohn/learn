package com.zh.learn.design_patterns.two_phase_termination;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-10
 */
public class EmptyUncaughtExceptionHandler {

    public static void main(String[] args) {

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup.getParent());
        System.out.println(threadGroup.getParent().getName());

        final Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }

            System.out.println(1 / 0);

        }, "test thread");

        thread.start();
    }

}
