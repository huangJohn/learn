package com.zh.learn.concurrency_test.container_exercise;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-13
 */
public class CompletableFutureExample1 {


    public static void main(String[] args) throws InterruptedException {

        IntStream.range(0, 10).boxed().forEach(i ->
                CompletableFuture.supplyAsync(CompletableFutureExample1::get)
                        .thenAccept(CompletableFutureExample1::display)
                        .whenComplete((v, t) -> System.out.println(Thread.currentThread().getName() + " done.")));

        Thread.currentThread().join();

    }


    private static int get() {

        int val = ThreadLocalRandom.current().nextInt(5);

        try {
            System.out.println(Thread.currentThread().getName() + " get() start.");
            TimeUnit.SECONDS.sleep(val);
            System.out.println(Thread.currentThread().getName() + " get() end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return val;
    }

    private static void display(int data) {

        int val = ThreadLocalRandom.current().nextInt(10);

        try {
            System.out.println(Thread.currentThread().getName() + " display() start.");
            TimeUnit.SECONDS.sleep(val);
            System.out.println(Thread.currentThread().getName() + " display data = " + data);
            System.out.println(Thread.currentThread().getName() + " display() end.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
