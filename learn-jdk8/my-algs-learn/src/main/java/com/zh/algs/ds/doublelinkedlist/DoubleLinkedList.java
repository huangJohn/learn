package com.zh.algs.ds.doublelinkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2021/3/8
 */
public class DoubleLinkedList {

    Node head;
    Node tail;

    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.push(1);
        doubleLinkedList.push(2);
        doubleLinkedList.push(3);
        doubleLinkedList.push(4);

        doubleLinkedList.printList(doubleLinkedList.head);

        doubleLinkedList.append(10);
        doubleLinkedList.append(11);
        doubleLinkedList.append(12);
        doubleLinkedList.append(13);

        doubleLinkedList.printList(doubleLinkedList.head);

        Node prevNode = doubleLinkedList.head.next.next;

        doubleLinkedList.insertAfter(prevNode, 99);
        doubleLinkedList.printList(doubleLinkedList.head);

        doubleLinkedList.insertBefore(prevNode, 98);
        doubleLinkedList.printList(doubleLinkedList.head);

    }


    public void push(int data) {

        Node node = new Node(data);

        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;
    }

    public void insertAfter(Node prevNode, int data) {

        if (prevNode == null) {
            System.out.println("The given previous node cannot be NULL");
            return;
        }

        Node node = new Node(data);

        node.next = prevNode.next;
        node.prev = prevNode;
        prevNode.next = node;

        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public void append(int data) {

        Node node = new Node(data);
        node.next = null;

        Node last = head;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;

    }

    public void insertBefore(Node nextNode, int data) {

        if (nextNode == null) {
            System.out.println("the given next node cannot be NULL");
            return;
        }

        Node node = new Node(data);

        node.prev = nextNode.prev;
        node.next = nextNode;
        nextNode.prev = node;

        if (node.prev != null) {
            node.prev.next = node;
        }

    }

    public void printList(Node node) {

        Node last = null;

        System.out.println("Traversal in forward Direction");

        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");

        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
        System.out.println();

    }

}
