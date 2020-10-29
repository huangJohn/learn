package com.zh.learn.exercise;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/11
 */
public class PrintNum {

    private static final Lock LOCK = new ReentrantLock();
    private static final Condition A = LOCK.newCondition();
    private static final Condition B = LOCK.newCondition();

    private static final AtomicInteger COUNT = new AtomicInteger(1);
    private static final int MAX = 21;

    public static void main(String[] args) {

        new Thread(new PrintNum.PrintB()).start();
        new Thread(new PrintNum.PrintA()).start();

    }

    private static class PrintA implements Runnable {
        @Override
        public void run() {
            try {
                LOCK.lock();
                while (true) {
                    while (COUNT.get() % 2 != 0) {
                        A.await();
                    }
                    if (COUNT.get() > MAX) {
                        break;
                    }
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100));
                    //偶数
                    System.out.print(COUNT.getAndIncrement() + "-");
                    B.signal();
                    if (COUNT.get() > MAX) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }

    private static class PrintB implements Runnable {
        @Override
        public void run() {
            try {
                LOCK.lock();
                while (true) {
                    while (COUNT.get() % 2 == 0) {
                        B.await();
                    }
                    Thread.sleep(ThreadLocalRandom.current().nextInt(200));
                    if (COUNT.get() > MAX) {
                        break;
                    }
                    //奇数
                    System.out.print(COUNT.getAndIncrement() + "-");
                    A.signal();
                    if (COUNT.get() > MAX) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }
}
