package com.zh.learn.exercise;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/11
 */
public class PrintABC3 {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static final int MAX = 30;

    public static void main(String[] args) {

        new Thread(new PrintABC3.PrintB()).start();
        new Thread(new PrintABC3.PrintA()).start();
        new Thread(new PrintABC3.PrintC()).start();
    }

    private static class PrintA implements Runnable {
        @Override
        public void run() {
            while (atomicInteger.get() < MAX) {
                if (atomicInteger.get() % 3 == 0) {
                    System.out.print("A");
                    atomicInteger.getAndIncrement();
                }
            }
        }
    }

    private static class PrintB implements Runnable {
        @Override
        public void run() {
            while (atomicInteger.get() < MAX) {
                if (atomicInteger.get() % 3 == 1) {
                    System.out.print("B");
                    atomicInteger.getAndIncrement();
                }
            }
        }
    }

    private static class PrintC implements Runnable {
        @Override
        public void run() {
            while (atomicInteger.get() < MAX) {
                if (atomicInteger.get() % 3 == 2) {
                    System.out.print("C ");
                    atomicInteger.getAndIncrement();
                }
            }
        }
    }


}
