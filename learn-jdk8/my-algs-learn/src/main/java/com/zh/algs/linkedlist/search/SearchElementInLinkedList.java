package com.zh.algs.linkedlist.search;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/8
 */
public class SearchElementInLinkedList {

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

        SearchElementInLinkedList test = new SearchElementInLinkedList();
        test.head = new Node(1);
        test.append(2);
        test.append(3);
        test.print();

        System.out.println("=========");

        System.out.println(test.search(3, test.head));
        System.out.println(test.searchByRecursive(3, test.head));

    }

    public boolean searchByRecursive(int data, Node head) {

        if (head == null) {
            return false;
        }

        if (head.data == data) {
            return true;
        }

        return searchByRecursive(data, head.next);
    }


    public boolean search(int data, Node head) {

        Node current = head;

        while (current != null) {

            if (current.data == data) {
                return true;
            }
            current = current.next;
        }

        return false;

    }


    public void print() {

        Node node = head;

        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
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
