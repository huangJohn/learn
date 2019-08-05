package com.zh.learn.design_patterns.latch;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-31
 */
public class ProgrammerTravel extends Thread {

    private final Latch latch;
    private final String programmer;
    private final String transportation;

    public ProgrammerTravel(Latch latch, String programmer, String transportation) {
        this.latch = latch;
        this.programmer = programmer;
        this.transportation = transportation;
    }

    @Override
    public void run() {
        System.out.println(programmer + " start take the transportation [ " + transportation + " ]");
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(programmer + " arrived by  [ " + transportation + " ]");
        latch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {

        Latch latch = new CustomizedCountDownLatch(4,()->{
            System.out.println(Thread.currentThread().getName() + "=====all of programmers arrived=======");
        });
//        new ProgrammerTravel(latch, "a", "bus").start();
//        new ProgrammerTravel(latch, "b", "walking").start();
//        new ProgrammerTravel(latch, "c", "subway").start();
//        new ProgrammerTravel(latch, "d", "bicycle").start();
//
//        latch.await();

        new ProgrammerTravel(latch, "a1", "bus").start();
        new ProgrammerTravel(latch, "b1", "walking").start();
        new ProgrammerTravel(latch, "c1", "subway").start();
        new ProgrammerTravel(latch, "d1", "bicycle").start();

        try {
            latch.await(TimeUnit.SECONDS, 3);
            System.out.println("=====all of programmers arrived=======");
        } catch (WaitTimeOutException e) {
            e.printStackTrace();
        }

    }
}
