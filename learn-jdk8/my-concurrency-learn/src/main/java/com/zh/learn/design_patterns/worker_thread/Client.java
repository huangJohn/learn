package com.zh.learn.design_patterns.worker_thread;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;


/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-13
 */
public class Client {

    public static void main(String[] args) {

        final ProductionChannel channel = new ProductionChannel(5);

        AtomicInteger atomicInteger = new AtomicInteger();

        IntStream.rangeClosed(1,8).forEach(i->{
            new Thread(() -> {
                while (true) {
                    channel.offerProduction(new Production(atomicInteger.getAndIncrement()));
                    try {
                        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });


    }

}
