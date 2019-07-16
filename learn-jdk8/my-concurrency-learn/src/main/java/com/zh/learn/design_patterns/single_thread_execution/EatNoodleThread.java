package com.zh.learn.design_patterns.single_thread_execution;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class EatNoodleThread extends Thread {

    private final String name;
    private final Tableware leftTool;
    private final Tableware rightTool;

    public EatNoodleThread(String name, Tableware leftTool, Tableware rightTool) {
        this.name = name;
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    @Override
    public void run() {

        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (leftTool) {
            System.out.println(name + " take up " + leftTool + " (left)");
            synchronized (rightTool) {
                System.out.println(name + " take up " + rightTool + " (right)");
                System.out.println(name + " is eating now");
                System.out.println(name + " put down " + rightTool + " (right)");
            }
            System.out.println(name + " put down " + leftTool + " (left)");
        }
    }

    public static void main(String[] args) {

        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        new EatNoodleThread("A", fork, knife).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new EatNoodleThread("B", knife, fork).start();
    }
}
