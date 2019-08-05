package com.zh.learn.design_patterns.thread_per_message;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-02
 */
public class MessageHandler {

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    private final static Executor EXECUTOR = Executors.newFixedThreadPool(5);

    public void request(Message message) {

        EXECUTOR.execute(() -> {
            String val = message.getVlaue();
            try {
                Thread.sleep(RANDOM.nextInt(1000));
                System.out.println("the message will is handled by " + Thread.currentThread().getName() + " value = " + val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    public void shutDown() {
        ExecutorService executor = (ExecutorService) EXECUTOR;
        executor.shutdown();
    }

}
