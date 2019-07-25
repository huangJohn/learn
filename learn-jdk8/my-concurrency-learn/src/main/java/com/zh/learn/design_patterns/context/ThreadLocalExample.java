package com.zh.learn.design_patterns.context;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-23
 */
public class ThreadLocalExample {

    public static void main(String[] args) {


        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        CountDownLatch latch = new CountDownLatch(10);

        IntStream.range(0,10).forEach(
                i->{
                    new Thread(() -> {
                        try {
                            threadLocal.set(i);
                            System.out.println(Thread.currentThread().getName() + " set i " + threadLocal.get());
                            TimeUnit.SECONDS.sleep(2);
                            System.out.println(Thread.currentThread().getName() + " get i " + threadLocal.get());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        latch.countDown();
                    }).start();
                }
        );

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("========================");

        ThreadLocal<Object> threadLocal1 = new ThreadLocal<Object>(){
            @Override
            protected Object initialValue() {
                return new Object();
            }
        };

        new Thread(() -> {
            Object o = threadLocal1.get();
            System.out.println(o);
        }).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadLocal1.get());
    }

}
