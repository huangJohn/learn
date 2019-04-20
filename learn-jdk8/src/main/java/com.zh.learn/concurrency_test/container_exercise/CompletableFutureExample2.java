package com.zh.learn.concurrency_test.container_exercise;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-17
 */
public class CompletableFutureExample2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        supplyAsync();


//        Future<Void> future = runAsync();
//        System.out.println(future.get());
//
//        Future<Void> hello = completed("hello");
//        System.out.println(hello.isDone());
//
//        Future<Void> hello = completed2("hello");
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println(hello.isDone());

//        allOf();

//        Future<?> future = anyOf();
//        System.out.println(future.get());

        Thread.currentThread().join();


    }


    /**
     * Description:
     * post ->{
     * basic info
     * detail info
     * <p>
     * 1  insert basic
     * 2  inset details
     * <p>
     * post   insert basic
     * post   insert details
     * <p>
     * 级联
     * }
     */
    private static void supplyAsync() {

        CompletableFuture.supplyAsync(Object::new).thenAcceptAsync(obj -> {
            try {
                System.out.println("obj:" + obj + "=====start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("obj=====" + obj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).runAfterBothAsync(CompletableFuture.supplyAsync(() -> "hello").thenAcceptAsync(s -> {
            try {
                System.out.println("string=====start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("string=====" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }), () -> {
            System.out.println("======finished=====");
        });

    }


    private static Future<Void> runAsync() {

        return CompletableFuture.runAsync(() -> {
            System.out.println("obj=====start");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("obj=====end");
        }).whenComplete((v, t) -> {
            System.out.println("=========over======");
        });
    }


    private static Future<Void> completed(String data) {

        return CompletableFuture.completedFuture(data).thenAccept(System.out::println);
    }

    private static Future<Void> completed2(String data) {

        return CompletableFuture.completedFuture(data).thenAcceptAsync(System.out::println);
    }

    private static void allOf() {
        CompletableFuture.allOf(CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println("1=====Start");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("1=====End");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).whenComplete((v, t) -> System.out.println("1=====over===")),
                CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("2=====Start");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("2=====End");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Hello";
                }).whenComplete((v, t) -> System.out.println(v + "=====over==="))
        );
    }


    private static Future<?> anyOf() {
        return CompletableFuture.anyOf(CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println("1=====Start");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("1=====End");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).whenComplete((v, t) -> System.out.println("1=====over===")),
                CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("2=====Start");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("2=====End");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Hello";
                }).whenComplete((v, t) -> System.out.println(v + "=====over==="))
        );
    }


}
