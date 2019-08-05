package com.zh.learn.design_patterns.producer_consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-31
 */
public class ConsumerThread extends Thread {

    private final MessageQueue messageQueue;
    private final static Random RANDOM = new Random(System.currentTimeMillis());
    private final static AtomicInteger counter = new AtomicInteger(0);


    public ConsumerThread(MessageQueue messageQueue, int seq) {
        super("ConsumerThread-" + seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + " take message " + message.getData());
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(10));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
