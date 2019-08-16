package com.zh.learn.design_patterns.active_objects.generic;

import com.zh.learn.design_patterns.active_objects.standard.ActiveDaemonThread;
import com.zh.learn.design_patterns.active_objects.standard.MethodMessage;

import java.util.LinkedList;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public class ActiveMessageGenericQueue {

    private final LinkedList<ActiveMessage> messages = new LinkedList<>();

    public ActiveMessageGenericQueue() {
        new ActiveDaemonGenericThread(this).start();
    }

    public void offer(ActiveMessage activeMessage) {

        synchronized (this) {
            messages.addLast(activeMessage);
            this.notify();//只有一个ActiveDaemonThread工作
        }
    }

    public ActiveMessage take() {
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
