package com.zh.algs.linkedlist.find;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/10
 */
public class FindGivenDataCountsInLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static int freq = 0;

    Node head;

    public static void main(String[] args) {
        FindGivenDataCountsInLinkedList test = new FindGivenDataCountsInLinkedList();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(1);

        test.print();

        System.out.println(test.findGivenDataCounts(1));
        System.out.println(test.findGivenDataCounts(9));

        System.out.println(test.findGivenDataCountsByRecursive(test.head, 1));
    }

    public int findGivenDataCounts(int data) {

        int count = 0;
        Node c = head;
        while (c != null) {
            if (c.data == data) {
                count++;
            }
            c = c.next;
        }
        return count;
    }

    public int findGivenDataCountsByRecursive(Node node, int data) {

        if (node == null) {
            return freq;
        }

        if (node.data == data) {
            freq++;
        }

        return findGivenDataCountsByRecursive(node.next, data);

    }

    public void print() {

        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }

        System.out.println();
    }

    public void push(int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

}
