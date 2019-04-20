package com.zh.learn.concurrency_test.container_exercise;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-20
 */
public class CompletableFutureExample3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * Description:
         * immediate to T
         */

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello")
//                .whenComplete((v, t) -> {
//            System.out.println("done");
//        });

//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "hello");
//        future2.whenCompleteAsync((v, t) -> {
//            try {
//                System.out.println("===========");
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("=====over====");
//        });
//
//        System.out.println("******");
//
//        System.out.println(future2.get());

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello")
//                .whenComplete((v, t) -> {
//                    try {
//                        System.out.println("===========");
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("=====over====");
//                });
//
//        System.out.println(future.get());

//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> "hello").thenApply(String::length);

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello");
//
//        CompletableFuture<Integer> future1 = future.thenApplyAsync(s -> {
//            try {
//                System.out.println("==========");
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("=====over====");
//            return s.length();
//        });

//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> "hello").thenApplyAsync(s -> {
//            try {
//                System.out.println("==========");
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("=====over====");
//            return s.length();
//        });

//        System.out.println(future.get());

        CompletableFuture<Integer> handle = CompletableFuture.supplyAsync((Supplier<String>) () -> {
            throw new RuntimeException("not get the data");
        }).handleAsync((s, t) -> {
            Optional.of(t).ifPresent(e -> System.out.println("error"));
            return s != null ? s.length() : 0;
        });

        System.out.println(handle.get());


        Thread.currentThread().join();
    }

}
