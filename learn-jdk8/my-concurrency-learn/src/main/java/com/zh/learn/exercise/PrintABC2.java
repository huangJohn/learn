package com.zh.learn.exercise;

import java.util.concurrent.Semaphore;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/11
 */
public class PrintABC2 {

    private static final Semaphore SEMAPHORE_A = new Semaphore(1);
    private static final Semaphore SEMAPHORE_B = new Semaphore(0);
    private static final Semaphore SEMAPHORE_C = new Semaphore(0);

    public static void main(String[] args) {

        new Thread(new PrintABC2.PrintB()).start();
        new Thread(new PrintABC2.PrintA()).start();
        new Thread(new PrintABC2.PrintC()).start();
    }

    private static class PrintA implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    SEMAPHORE_A.acquire(1);
                    System.out.print("A");
                    SEMAPHORE_B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PrintB implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    SEMAPHORE_B.acquire(1);
                    System.out.print("B");
                    SEMAPHORE_C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class PrintC implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    SEMAPHORE_C.acquire(1);
                    System.out.print("C ");
                    SEMAPHORE_A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
