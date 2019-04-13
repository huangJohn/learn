package com.zh.learn.concurrency_test.design.worker_thread;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

/**
 * worker thread设计模式和生产消费者模式区别在于
 * 生产者消费者对队列都是依赖关系，队列既不知producer的存在也不知consumer的存在，consumer对队列的消费也不依赖数据本身的方法
 * 而相反，worker对于channel不是简单的依赖关系，而是聚合关系，channel必须知道worker的存在，worker对数据加工也是依赖了数据本身定制的方法
 */
public class ProductionChannel {

    private final static int MAX_PRODUCTION = 100;

    private final Production[] productionQueue;

    private int tail;

    private int head;

    private int total;

    private final Worker[] workers;

    public ProductionChannel(int workerSize) {

        workers = new Worker[workerSize];
        productionQueue = new Production[MAX_PRODUCTION];
        for (int i = 0; i < workerSize; i++) {
            workers[i] = new Worker("Worker-" + i, this);
            workers[i].start();
        }
    }

    public void offerProduction(Production production) {
        synchronized (this) {
            while (total >= productionQueue.length) {
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
