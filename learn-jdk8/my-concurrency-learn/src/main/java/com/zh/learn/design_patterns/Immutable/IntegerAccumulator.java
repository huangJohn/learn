package com.zh.learn.design_patterns.Immutable;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-17
 */
public final class IntegerAccumulator {

    private final int init;

    public IntegerAccumulator(int init) {
        this.init = init;
    }

    public IntegerAccumulator(IntegerAccumulator integerAccumulator, int init) {
        this.init = integerAccumulator.getValue() + init;
    }

    public int getValue() {
        return this.init;
    }

    public IntegerAccumulator add(int value) {
        return new IntegerAccumulator(this, value);
    }

    public static void main(String[] args) {

        IntegerAccumulator integerAccumulator = new IntegerAccumulator(0);
        IntStream.range(0, 3).forEach(i -> {
            new Thread(() -> {
                int increment = 0;
                while (true) {
                    int oldValue = integerAccumulator.getValue();
                    int value = integerAccumulator.add(increment).getValue();
                    System.out.println(Thread.currentThread().getName() + " => " + oldValue + " + " + increment + " = " + value);
                    if (increment + oldValue != value) {
                        System.err.println("error: " + oldValue + " + " + increment + " = " + value);
                    }
                    increment++;
                    slowly();
                }
            }).start();
        });
    }

    private static void slowly() {

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
