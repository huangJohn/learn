package com.zh.algs.linkedlist.find;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/10
 */
public class FindCycleLength {

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
        FindCycleLength test = new FindCycleLength();
        test.head = new Node(1);
        test.append(2);
        test.append(3);
        test.append(4);

        test.head.next.next.next.next = test.head.next;

        System.out.println(test.findCycleLength());

    }

    public int findCycleLength() {

        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return getCycleLength(slow);
            }
        }

        return -1;
    }

    private int getCycleLength(Node node) {

        Node tmp = node;
        int count = 1;
        while (tmp.next != node) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public void append(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }


}
