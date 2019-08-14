package com.zh.learn.design_patterns.active_objects.standard;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-14
 */
public class ActiveDaemonThread extends Thread {

    private final ActiveMessageQueue activeMessageQueue;

    public ActiveDaemonThread(ActiveMessageQueue activeMessageQueue) {
        super("ActiveDaemonThread");
        this.activeMessageQueue = activeMessageQueue;
        setDaemon(true);
    }

    @Override
    public void run() {
        for (; ; ) {
            MethodMessage methodMessage = this.activeMessageQueue.take();
            methodMessage.execute();
        }
    }
}
