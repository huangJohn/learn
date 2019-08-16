package com.zh.learn.design_patterns.active_objects.generic;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public class ActiveDaemonGenericThread extends Thread {
    private final ActiveMessageGenericQueue activeMessageGenericQueue;

    public ActiveDaemonGenericThread(ActiveMessageGenericQueue activeMessageGenericQueue) {
        super("ActiveDaemonThread");
        this.activeMessageGenericQueue = activeMessageGenericQueue;
        setDaemon(true);
    }

    @Override
    public void run() {
        for (; ; ) {
            ActiveMessage activeMessage = this.activeMessageGenericQueue.take();
            activeMessage.execute();
        }
    }
}
