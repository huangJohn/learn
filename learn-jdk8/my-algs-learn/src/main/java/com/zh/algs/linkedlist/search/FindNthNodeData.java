package com.zh.algs.linkedlist.search;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/8
 */
public class FindNthNodeData {

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

        FindNthNodeData data = new FindNthNodeData();
        data.head = new Node(3);
        data.push(5);
        data.push(7);
        data.print();

        System.out.println(data.getNthOfNodeData(2));
        System.out.println(data.getNthOfNodeData(5));

    }

    public int getNthOfNodeData(int index) {

        Node cur = head;
        int count = 0;

        while (cur != null) {

            if (count == index) {
                return cur.data;
            }
            count++;
            cur = cur.next;
        }

        assert (false);

        return -1;
    }

    public void print() {

        Node c = head;
        while (c != null) {
            System.out.print(c.data + " -> ");
            c = c.next;
        }
        System.out.println();
    }

    public void push(int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

}
