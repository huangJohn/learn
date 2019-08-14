package com.zh.learn.design_patterns.active_objects.standard;

import java.util.LinkedList;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
public class ActiveMessageQueue {

    private final LinkedList<MethodMessage> messages = new LinkedList<>();

    public ActiveMessageQueue() {
        new ActiveDaemonThread(this).start();
    }

    public void offer(MethodMessage methodMessage) {

        synchronized (this) {
            messages.addLast(methodMessage);
            this.notify();//只有一个ActiveDaemonThread工作
        }
    }

    public MethodMessage take() {
        synchronized (this) {
            while (messages.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return messages.removeFirst();
        }
    }
}
