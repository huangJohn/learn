package com.zh.algs.linkedlist.insert;


/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/7
 */
public class InsertLinkedList {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;


    public void push(int data) {

        Node node = new Node(data);

        node.next = head;
        head = node;

    }

    public void insertAfter(Node prev, int data) {

        if (prev == null) {
            System.out.println("the given previous node cannot be null");
            return;
        }

        Node node = new Node(data);
        node.next = prev.next;
        prev.next = node;

    }

    public void append(int data) {

        Node new_append = new Node(data);

        //头指针null，直接指向新的data
        if (head == null) {
            head = new_append;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_append;
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

        InsertLinkedList insertLinkedList = new InsertLinkedList();
        insertLinkedList.push(1);
        insertLinkedList.printLinkedList();
        insertLinkedList.push(2);
        insertLinkedList.printLinkedList();

        System.out.println("push done");

        insertLinkedList.insertAfter(insertLinkedList.head, 3);
        insertLinkedList.printLinkedList();
        insertLinkedList.insertAfter(insertLinkedList.head.next, 4);
        insertLinkedList.printLinkedList();

        System.out.println("insert after done");

        insertLinkedList.append(5);
        insertLinkedList.printLinkedList();
        insertLinkedList.append(6);
        insertLinkedList.printLinkedList();
        System.out.println("append done");


    }

}
