package com.zh.learn.concurrency_test.container_exercise;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class ExchangerExample3 {

    public static void main(String[] args) {

        /**
         * Description:测试exchanger交换的object引用是否同一个，交换的object是当前线程持有的object
         *
         * @param
         * @return
         */

        Exchanger<Object> exchanger = new Exchanger<>();

        new Thread(()->{
            try {

                Object object = new Object();
                System.out.println(Thread.currentThread().getName() + " first sends object :" + object);

                Object exchange = exchanger.exchange(object);

                TimeUnit.SECONDS.sleep(2);

                System.out.println(Thread.currentThread().getName() + " first receives object :" + exchange);

                System.out.println(Thread.currentThread().getName() + " seconds sends object :" + object);

                Object exchange1 = exchanger.exchange(exchange);

                TimeUnit.SECONDS.sleep(2);

                System.out.println(Thread.currentThread().getName() + " seconds receives object :" + exchange1);

            } catch (Exception e) {
                e.printStackTrace();
            }


        },"a").start();

        new Thread(()->{
            try {

                Object object = new Object();
                System.out.println(Thread.currentThread().getName() + " first sends object :" + object);

                Object exchange = exchanger.exchange(object);

                TimeUnit.SECONDS.sleep(3);

                System.out.println(Thread.currentThread().getName() + " first receives object :" + exchange);

                System.out.println(Thread.currentThread().getName() + " seconds sends object :" + object);

                Object exchange1 = exchanger.exchange(exchange);

                TimeUnit.SECONDS.sleep(3);

                System.out.println(Thread.currentThread().getName() + " seconds receives object :" + exchange1);

            } catch (Exception e) {
                e.printStackTrace();
            }


        },"b").start();
    }
}
