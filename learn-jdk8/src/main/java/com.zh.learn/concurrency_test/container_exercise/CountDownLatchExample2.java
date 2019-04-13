package com.zh.learn.concurrency_test.container_exercise;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample2 {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 场景
         * 有一个主任务执行，刚开始有耗时的操作，比如说初始化加载资源，初始化任务可以分子任务并行执行，
         * 可以被视为分子任务进行，
         * 启用多个线程并行执行初始化工作，当沉重的初始化任务结束后，利用latch down计数和阻塞功能，子线程任务结束后
         * latch down为0，同时可能其他线程早处于block状态，完成后执行后面的工作，此场景的目的时启用子线程并行执行任务
         * 初始化的工作，以减少时间。比如，串行化执行需要1+2=3分钟，而将data准备工作的2分钟用latch工具做，时长缩短为2分钟
         *
         * */

        final CountDownLatch latch = new CountDownLatch(1);

        new Thread("A") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " do some initial work");
                try {
                    Thread.sleep(1000);
                    //asy
                    latch.await();
                    System.out.println(Thread.currentThread().getName() + " do other work");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        new Thread("B") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " asy prepare for some data");
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " prepare work done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }

            }
        }.start();

        new Thread("C") {
            @Override
            public void run() {
                try {
                    latch.await();
                    System.out.println(Thread.currentThread().getName() + " release");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

//        Thread.currentThread().join();
    }


}
