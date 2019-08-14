package com.zh.learn.design_patterns.future;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 * <p>
 * 将调用执行逻辑进行了隔离
 */
public class FutureTask<OUT> implements Future<OUT> {

    //计算的结果
    private OUT result;

    //任务是否完成
    private boolean isDone = false;

    //lock obj
    private final Object LOCK = new Object();

    @Override
    public OUT get() throws InterruptedException {
        synchronized (LOCK) {
            while (!isDone) {
                LOCK.wait();
            }
            return result;
        }
    }

    protected void finish(OUT result) {
        synchronized (LOCK) {
            if (isDone) {
                return;
            }
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }

    @Override
    public boolean done() {
        return isDone;
    }
}
