package com.zh.learn.design_patterns.single_thread_execution;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class EatNoodleThreadSafe extends Thread {

    private final String name;

    private final TablewarePair tablewarePair;

    public EatNoodleThreadSafe(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (tablewarePair) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " take up " + tablewarePair.getLeftTool() + " (left)");
            System.out.println(name + " take up " + tablewarePair.getRightTool() + " (right)");
            System.out.println(name + " is eating now");
            System.out.println(name + " put down " + tablewarePair.getRightTool() + " (right)");
            System.out.println(name + " put down " + tablewarePair.getLeftTool() + " (left)");
        }
    }

    public static void main(String[] args) {

        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        TablewarePair pair = new TablewarePair(fork, knife);
        new EatNoodleThreadSafe("A", pair).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new EatNoodleThreadSafe("B", pair).start();
    }
}
