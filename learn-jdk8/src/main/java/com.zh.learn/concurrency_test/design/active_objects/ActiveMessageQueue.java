package com.zh.learn.concurrency_test.design.active_objects;

import java.util.LinkedList;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class ActiveMessageQueue {

    /**
     * 对应流水线模型中的传送带，作用是传送调用线程通过proxy提交过来的MethodMessage
     */

    //存放提交过来的MethodMessage
    private final LinkedList<ActiveMessage> messages = new LinkedList<>();

    public ActiveMessageQueue() {
        //启动worker线程
        new ActiveDaemonThread(this).start();
    }

    public void offer(ActiveMessage activeMessage) {
        synchronized (this) {
            messages.addLast(activeMessage);
            /**
             * 只有一个worker线程负责take数据
             */
            this.notify();
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
