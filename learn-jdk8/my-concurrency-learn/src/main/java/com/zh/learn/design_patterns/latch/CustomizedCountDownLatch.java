package com.zh.learn.design_patterns.latch;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-31
 */
public class CustomizedCountDownLatch extends Latch {

    private Runnable runnable;

    public CustomizedCountDownLatch(int limit) {
        super(limit);
    }

    public CustomizedCountDownLatch(int limit, Runnable runnable) {
        super(limit);
        this.runnable = runnable;
    }

    @Override
    public void await() throws InterruptedException {
        synchronized (this) {
            while (limit > 0) {
                this.wait();
            }
        }
        if (null != runnable) {
            runnable.run();
        }
    }

    @Override
    public void await(TimeUnit unit, long time) throws InterruptedException, WaitTimeOutException {
        if (time <= 0) {
            throw new IllegalArgumentException("the time is invalid.");
        }

        long remainingNanos = unit.toNanos(time);

        //等待的任务将在endNanos后超时
        final long endNanos = System.nanoTime() + remainingNanos;

        synchronized (this) {
            while (limit > 0) {

                //如果超时则抛出WaitTimeOutException
                if (TimeUnit.NANOSECONDS.toMillis(remainingNanos) <= 0) {
                    throw new WaitTimeOutException("the wait time over specify time.");
                }

                //等待remainingNanos，等待过程中如果被中断，则重新计算remainingNanos
                this.wait(TimeUnit.NANOSECONDS.toMillis(remainingNanos));
                remainingNanos = endNanos - System.nanoTime();
            }
        }

        if (null != runnable) {
            runnable.run();
        }
    }

    @Override
    public void countDown() {
        synchronized (this) {
            if (limit <= 0) {
                throw new IllegalStateException("all of task already arrived.");
            }

            limit--;
            this.notifyAll();

        }
    }

    @Override
    public int getUnarrived() {
        return limit;
    }

}
