package com.zh.algs.linkedlist.find;

import java.util.HashSet;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/10
 */
public class FIndIsExistCycle {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public static void main(String[] args) {

        FIndIsExistCycle test = new FIndIsExistCycle();
        test.head = new Node(1);
        test.insertAfter(test.head, 2);
        test.insertAfter(test.head.next, 3);
        test.insertAfter(test.head.next.next, 4);
        test.insertAfter(test.head.next, 5);
//        test.print();
        test.head.next.next.next = test.head;

        System.out.println(test.findCycleByHashing());
        System.out.println(test.findCycleByTwoPt());

    }

    public void print() {
        Node c = head;
        while (c != null) {
            System.out.print(c.data + " -> ");
            c = c.next;
        }
        System.out.println();
    }

    public boolean findCycleByTwoPt() {

        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;

    }

    public boolean findCycleByHashing() {

        Node cur = head;

        HashSet<Node> set = new HashSet<>();

        while (cur != null) {

            if (!set.contains(cur)) {
                set.add(cur);
                cur = cur.next;
            } else {
                return true;
            }

        }
        return false;


    }

    public void insertAfter(Node prev, int data) {

        if (prev == null) {
            System.out.println("prev node cannot be null");
            return;
        }


        Node newNode = new Node(data);

        newNode.next = prev.next;
        prev.next = newNode;
    }


}
