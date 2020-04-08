package com.zh.algs.linkedlist.travelsal;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/7
 */
public class TraversalLinkedList {

    Node head;

    private static class Node {

        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void printLinkedList() {

        Node n = head;

        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }

        System.out.println();

    }


    public static void main(String[] args) {

        TraversalLinkedList traversalLinkedList = new TraversalLinkedList();

        traversalLinkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        traversalLinkedList.head.next = second;
        second.next = third;

        traversalLinkedList.printLinkedList();

    }



}
