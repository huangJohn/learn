package com.zh.learn.design_patterns.worker_thread;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-13
 */
public class ProductionChannel {

    private final static int MAX_PRODUCT = 100;//最大

    private final Production[] productionQueue;

    private int tail;
    private int head;
    private int total;//当前总共

    private final Worker[] workers;

    public ProductionChannel(int workerSize) {
        this.workers = new Worker[workerSize];
        this.productionQueue = new Production[MAX_PRODUCT];
        for (int i = 0; i < workerSize; i++) {
            workers[i] = new Worker("worker-" + i, this);
            workers[i].start();
        }
    }

    public void offerProduction(Production production) {
        synchronized (this) {
            while (total > productionQueue.length) {
                try {
                    this.wait();
                } catch (InterruptedException e) {

                }
            }
            productionQueue[tail] = production;
            tail = (tail + 1) % productionQueue.length;
            total++;
            this.notifyAll();
        }
    }

    public Production takeProduction() {
        synchronized (this) {
            while (total <= 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {

                }
            }
            Production production = productionQueue[head];
            head = (head + 1) % productionQueue.length;
            total--;
            this.notifyAll();
            return production;
        }
    }
}
