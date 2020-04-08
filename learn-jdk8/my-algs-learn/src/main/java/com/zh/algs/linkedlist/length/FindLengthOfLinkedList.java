package com.zh.algs.linkedlist.length;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/7
 */
public class FindLengthOfLinkedList {

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

        FindLengthOfLinkedList findLengthOfLinkedList = new FindLengthOfLinkedList();
        findLengthOfLinkedList.append(1);
        findLengthOfLinkedList.append(2);
        findLengthOfLinkedList.append(3);

        System.out.println(findLengthOfLinkedList.findLengthByIter());
        System.out.println(findLengthOfLinkedList.findLengthByRecursive());
    }

    public int findLengthByIter() {

        int count = 0;

        Node c = head;
        while (c != null) {
            count++;
            c = c.next;
        }

        return count;
    }

    public int findLengthByRecursive() {
        return findLengthRec(head);
    }

    private int findLengthRec(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + findLengthRec(node.next);
    }

    public void append(int data) {

        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
    }

    public void print() {

        Node c = head;
        while (c != null) {
            System.out.print(c.data + " -> ");
            c = c.next;
        }
        System.out.println();
    }


}
