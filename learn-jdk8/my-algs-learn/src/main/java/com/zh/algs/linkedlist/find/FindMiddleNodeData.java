package com.zh.algs.linkedlist.find;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/10
 */
public class FindMiddleNodeData {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;



    public int findMiddleNode() {

        if (head != null) {
            Node fir = head;
            Node sec = head;
            while (sec != null && sec.next != null) {
                fir = fir.next;
                sec = sec.next.next;
            }
            return fir.data;
        }
        return -1;
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


    public static void main(String[] args) {

        FindMiddleNodeData test = new FindMiddleNodeData();
        test.head = new Node(1);
        test.append(2);
        test.append(3);
        test.append(4);
        test.print();

        System.out.println(test.findMiddleNode());
    }

}
