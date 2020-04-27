package com.zh.algs.linkedlist.find;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/27
 */
public class FindCycleEntrance {

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


        FindCycleEntrance findCycleEntrance = new FindCycleEntrance();
        findCycleEntrance.head = new Node(1);
        findCycleEntrance.push(2);
        findCycleEntrance.push(3);
        findCycleEntrance.push(4);
        findCycleEntrance.push(5);
        findCycleEntrance.head.next.next.next.next.next = findCycleEntrance.head.next;

        System.out.println(findCycleEntrance.detectCycleEntrance().data);


    }


    public Node detectCycleEntrance() {

        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return null;
        }

        slow = head;
        /**
         * Description:
         * a=（x-2y）*n -k
         * 同速度1，必然在入口相遇
         */
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void push(int data) {

        Node node = new Node(data);

        if (head == null) {
            head = node;
            return;
        }

        node.next = head;
        head = node;
    }

}
