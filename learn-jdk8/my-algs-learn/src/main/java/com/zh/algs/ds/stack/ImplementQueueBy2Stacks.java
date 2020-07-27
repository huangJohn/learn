package com.zh.algs.ds.stack;

import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/27
 */
public class ImplementQueueBy2Stacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        ImplementQueueBy2Stacks implementQueueBy2Stacks = new ImplementQueueBy2Stacks();
        implementQueueBy2Stacks.enQueue(1);
        implementQueueBy2Stacks.enQueue(2);
        implementQueueBy2Stacks.enQueue(3);
        implementQueueBy2Stacks.enQueue(4);

        System.out.println(implementQueueBy2Stacks.deQueue());
        System.out.println(implementQueueBy2Stacks.deQueue());
        System.out.println(implementQueueBy2Stacks.deQueue());
        System.out.println(implementQueueBy2Stacks.deQueue());
        System.out.println(implementQueueBy2Stacks.deQueue());

    }

    public void enQueue(int x) {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int deQueue() {
        if (stack1.isEmpty()) {
            System.out.println("queus is empty");
            System.exit(0);
        }

        Integer peek = stack1.peek();
        stack1.pop();
        return peek;
    }


}
