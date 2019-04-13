package com.zh.learn.concurrency_test.lock_defined;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zhuanghuang
 * @date 2018/6/7
 */

public class LockTest {

    public static void main(String[] args) {

        final BooleanLock booleanLock = new BooleanLock();

        Stream.of("t1", "t2", "t3", "t4").forEach(name -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        booleanLock.lock(1000L);

                        System.out.println(Thread.currentThread().getName() + " have the lock.");
                        work();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (TimeOutException e) {
//                        e.printStackTrace();
                        System.out.println(Thread.currentThread().getName() + " time out");
                    } finally {
                        booleanLock.unlock();
                    }
                }
            }, name).start();
        });
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is Working...")
                .ifPresent(System.out::println);
        Thread.sleep(10_000);
    }
}
