package com.zh.learn.design_patterns.guarded_suspension;

import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * Description:共享资源处于临界时，线程挂起，生产消费者模式广泛应用
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-17
 */
public class GuardedSuspensionQueue {

    private final LinkedList<Integer> queue = new LinkedList<>();

    private final int LIMIT = 100;

    public void offer(Integer x) throws InterruptedException {
        synchronized (this) {
            while (queue.size() >= LIMIT) {
                this.wait();
            }
            queue.addLast(x);
            this.notifyAll();
        }
    }

    public Integer take() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                this.wait();
            }
            this.notifyAll();
            return queue.removeFirst();
        }
    }

    public static void main(String[] args) {

        GuardedSuspensionQueue queue = new GuardedSuspensionQueue();

        IntStream.range(0, 5).forEach(i -> {
            new Thread(() -> {
                try {
                    while (true) {
                        queue.offer(1);
                        Thread.sleep(2_000);
                        System.out.println(Thread.currentThread().getName() + " add data " + 1 + " done");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });

        IntStream.range(0, 2).forEach(i -> {
            new Thread(() -> {
                try {
                    while (true) {
                        Integer take = queue.take();
                        Thread.sleep(2_000);
                        System.out.println(Thread.currentThread().getName() + " take data " + take + " done");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}
