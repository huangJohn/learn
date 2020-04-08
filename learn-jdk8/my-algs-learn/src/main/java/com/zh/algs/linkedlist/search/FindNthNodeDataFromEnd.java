package com.zh.algs.linkedlist.search;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/8
 */
public class FindNthNodeDataFromEnd {

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

        FindNthNodeDataFromEnd test = new FindNthNodeDataFromEnd();
        test.append(1);
        test.append(2);
        test.append(3);
        test.append(3);
        test.append(3);

        test.print();

        test.findNthNodeDataFromEnd(4);
        test.findNthNodeDataFromEnd(8);

    }


    public void findNthNodeDataFromEnd(int n) {

        int length = findLength();

        if (length < n) {
            System.out.println("num n 大于链表长度了");
            return;
        }

        Node tmp = head;

        for (int i = 1; i < length - n + 1; i++) {
            tmp = tmp.next;
        }

        System.out.println(tmp.data);



    }

    public int findLength() {

        return findLengthByRecursive(head);
    }

    private int findLengthByRecursive(Node node) {

        if (node == null) {
            return 0;
        }

        return 1 + findLengthByRecursive(node.next);
    }


    public void print() {

        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println();
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
