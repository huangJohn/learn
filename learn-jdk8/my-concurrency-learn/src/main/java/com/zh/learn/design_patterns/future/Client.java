package com.zh.learn.design_patterns.future;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {

        FutureService<Void, Void> futureService = FutureService.newService();

        Future<?> future = futureService.submit(
                () -> {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("i am runnable and finish done");
                }
        );//asyn 10s

        System.out.println("do other 1....");
        System.out.println("do other 2....");
        //syn 2s
        try {
            TimeUnit.MILLISECONDS.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("do other 3....");

        //阻塞
        Object s = future.get();
        System.out.println(s);

        FutureService<String, Integer> futureService1 = FutureService.newService();
        Future<Integer> future1 = futureService1.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "hello");
        System.out.println(future1.get());

        Future<Integer> future2 = futureService1.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "hello", System.out::println);

    }

}
