package com.zh.learn.concurrency_test.container_exercise;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/2
 */
public class CountDownLatchExample3 {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread mainThread = Thread.currentThread();

        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            countDownLatch.countDown();
            //如果子线程中始终执行不到countDown方法，则需要在外部中断
            //外部主线程是main线程调用await方法，因此在子线程中可尝试中断
            mainThread.interrupt();


        }).start();

        /**
         * Description:await(2, TimeUnit.SECONDS)被中断或者超时后立即返回
         *
         * @param
         * @return
         */
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
        System.out.println("=============");
        countDownLatch.countDown();

    }

}
