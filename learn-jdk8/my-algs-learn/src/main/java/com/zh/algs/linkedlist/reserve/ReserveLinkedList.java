package com.zh.algs.linkedlist.reserve;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/10
 */
public class ReserveLinkedList {

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

        ReserveLinkedList reserveLinkedList = new ReserveLinkedList();
        reserveLinkedList.push(1);
        reserveLinkedList.push(2);
        reserveLinkedList.push(3);
        reserveLinkedList.print();

        reserveLinkedList.reserve();
        reserveLinkedList.print();
        reserveLinkedList.reserve();
        reserveLinkedList.print();
    }

    public void reserve() {

        Node cur = head;
        Node prev = null;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head = prev;

    }


    public void push(int data) {

        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }


}
