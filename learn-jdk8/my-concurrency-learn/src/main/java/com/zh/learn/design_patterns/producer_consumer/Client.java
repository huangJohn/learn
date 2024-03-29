package com.zh.learn.design_patterns.producer_consumer;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-31
 */
public class Client {
    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue();

        new ProducerThread(messageQueue, 1).start();
        new ProducerThread(messageQueue, 2).start();
        new ProducerThread(messageQueue, 3).start();
        new ConsumerThread(messageQueue, 1).start();
        new ConsumerThread(messageQueue, 2).start();
        new ConsumerThread(messageQueue, 3).start();
        new ConsumerThread(messageQueue, 4).start();
        new ConsumerThread(messageQueue, 5).start();
    }

}
