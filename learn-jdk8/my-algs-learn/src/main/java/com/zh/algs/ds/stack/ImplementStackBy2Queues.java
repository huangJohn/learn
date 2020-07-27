package com.zh.algs.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/27
 */
public class ImplementStackBy2Queues {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private int size;

    public ImplementStackBy2Queues() {
        this.size = 0;
    }

    public static void main(String[] args) {

        ImplementStackBy2Queues s = new ImplementStackBy2Queues();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());

        System.out.println("current size: " + s.size());

    }

    public void push(int x) {

        size++;
        queue2.add(x);

        while (!queue1.isEmpty()) {
            queue2.add(queue1.peek());
            queue1.remove();
        }

        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public void pop() {
        if (queue1.isEmpty()) {
            return;
        }
        queue1.remove();
        size--;
    }

    public int peek() {
        if (queue1.isEmpty()) {
            return -1;
        }
        return queue1.peek();
    }

    public int size() {
        return size;
    }

}
