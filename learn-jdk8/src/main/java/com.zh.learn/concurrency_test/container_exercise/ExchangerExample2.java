package com.zh.learn.concurrency_test.container_exercise;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/3
 */
public class ExchangerExample2 {

    /**
     * Description:两个线程彼此互相赋值
     *
     * @param
     * @return
     */
    public static void main(String[] args) {

        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread("a") {
            @Override
            public void run() {

                AtomicReference<Integer> x = new AtomicReference<>(0);
                x.set(1);

                while (true) {

                    Integer integer = null;
                    try {
                        // from b
                        integer = exchanger.exchange(x.get());
                        x.set(integer);
                        System.out.println(Thread.currentThread().getName() + " has value : " + x.get());
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("b") {
            @Override
            public void run() {

                AtomicReference<Integer> y = new AtomicReference<>(0);
                y.set(2);

                while (true) {

                    Integer integer = null;
                    try {
                        // from a
                        integer = exchanger.exchange(y.get());
                        y.set(integer);
                        System.out.println(Thread.currentThread().getName() + " has value : " + y.get());
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}
