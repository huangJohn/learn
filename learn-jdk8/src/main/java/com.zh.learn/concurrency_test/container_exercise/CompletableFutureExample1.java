package com.zh.learn.concurrency_test.container_exercise;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/***************************************
 * @author:Alex Wang
 * @Date:2017/9/2
 * QQ交流群:601980517，463962286
 ***************************************/
public class CompletableFutureExample1 {
    public static void main(String[] args) throws InterruptedException {

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        Future<?> future = executorService.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        while (!future.isDone()) {
//
//        }
//        System.out.println("DONE");

//        CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).whenComplete((v, t) -> System.out.println("DONE"));
//        System.out.println("========i am not blocked=========");
//        Thread.currentThread().join();

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        List<Callable<Integer>> tasks = IntStream.range(0, 5).boxed()
//                .map(i -> (Callable<Integer>) () -> getFromDb()).collect(toList());
//
//        executorService.invokeAll(tasks).stream().map(future -> {
//            try {
//                return future.get();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }).parallel().forEach(i -> print(i));


        IntStream.range(0, 5).boxed()
                .forEach(i -> CompletableFuture.supplyAsync(CompletableFutureExample1::getFromDb)
                        .thenAccept(CompletableFutureExample1::print)
                        .whenComplete((v, t) -> System.out.println(i + " DONE"))
                );
        Thread.currentThread().join();
    }

    private static void print(int data) {

        int value = ThreadLocalRandom.current().nextInt(5);
        try {
            System.out.println(Thread.currentThread().getName() + " print will be sleep " + value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " print execute done " + data);
    }

    private static int getFromDb() {

        int value = ThreadLocalRandom.current().nextInt(5);

        try {
            System.out.println(Thread.currentThread().getName() + " getFromDb will be sleep " + value);
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " getFromDb execute done " + value);
        return value;
    }
}
