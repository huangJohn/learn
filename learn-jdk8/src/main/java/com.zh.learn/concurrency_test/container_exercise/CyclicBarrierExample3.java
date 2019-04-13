package com.zh.learn.concurrency_test.container_exercise;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class CyclicBarrierExample3 {

    /**
     * Description:用countdown latch模拟barrier的回调通知功能
     *
     * @param
     * @return
     */

    public static void main(String[] args) {

        MyCountDownLatch latch = new MyCountDownLatch(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all of work finished done.");
            }
        });

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 has finished done");
            latch.countDown();
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 has finished done");
            latch.countDown();
        }).start();

        System.out.println("============");
    }

    private static class MyCountDownLatch extends CountDownLatch {

        private final Runnable runnable;

        /**
         * Constructs a {@code CountDownLatch} initialized with the given count.
         *
         * @param count the number of times {@link #countDown} must be invoked
         *              before threads can pass through {@link #await}
         * @param runnable
         * @throws IllegalArgumentException if {@code count} is negative
         */
        public MyCountDownLatch(int count, Runnable runnable) {
            super(count);
            this.runnable = runnable;
        }

        @Override
        public void countDown() {
            super.countDown();
            if (getCount() == 0) {
                this.runnable.run();
            }
        }
    }
}
