package com.zh.learn.design_patterns.latch;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-30
 */
public abstract class Latch {

    protected int limit;

    public Latch(int limit) {
        this.limit = limit;
    }

    public abstract void await() throws InterruptedException;

    /**
     * Description:
     * 只提供门阀作用，当执行任务超时后，抛出异常，但是未完成任务不会被中断还会继续执行，
     * latch并不对线程控制，需要开发人员自己控制
     */
    public abstract void await(TimeUnit unit, long time) throws InterruptedException, WaitTimeOutException;

    public abstract void countDown();

    public abstract int getUnarrived();
}
