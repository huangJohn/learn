package com.zh.learn.exercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/11
 */
public class PrintABC {

    private static final Lock LOCK = new ReentrantLock();
    private static final Condition A = LOCK.newCondition();
    private static final Condition B = LOCK.newCondition();
    private static final Condition C = LOCK.newCondition();

    private static int COUNT = 0;

    public static void main(String[] args) {

        new Thread(new PrintB()).start();
        new Thread(new PrintA()).start();
        new Thread(new PrintC()).start();

    }

    private static class PrintA implements Runnable {
        @Override
        public void run() {
            try {
                LOCK.lock();
                for (int i = 0; i < 10; i++) {
                    while (COUNT % 3 != 0) {
                        A.await();
                    }
                    System.out.print("A");
                    COUNT++;
                    B.signal();
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
                for (int i = 0; i < 10; i++) {
                    while (COUNT % 3 != 1) {
                        B.await();
                    }
                    System.out.print("B");
                    COUNT++;
                    C.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }

    private static class PrintC implements Runnable {
        @Override
        public void run() {
            try {
                LOCK.lock();
                for (int i = 0; i < 10; i++) {
                    while (COUNT % 3 != 2) {
                        C.await();
                    }
                    System.out.print("C ");
                    COUNT++;
                    A.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        }
    }




}
