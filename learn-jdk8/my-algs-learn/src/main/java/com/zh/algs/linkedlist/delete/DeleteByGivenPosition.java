package com.zh.algs.linkedlist.delete;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/7
 */
public class DeleteByGivenPosition {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;

    public static void main(String[] args) {

        DeleteByGivenPosition deleteByGivenPosition = new DeleteByGivenPosition();
        deleteByGivenPosition.head = new Node(1);
        deleteByGivenPosition.push(2);
        deleteByGivenPosition.push(3);
        deleteByGivenPosition.push(4);
        deleteByGivenPosition.print();


        deleteByGivenPosition.deleteByGivenPosition(2);
        deleteByGivenPosition.print();

        deleteByGivenPosition.deleteByGivenPosition(5);
        deleteByGivenPosition.print();

        deleteByGivenPosition.deleteByGivenPosition(8);
        deleteByGivenPosition.print();

        deleteByGivenPosition.deleteByGivenPosition(0);
        deleteByGivenPosition.print();
    }

    public void deleteByGivenPosition(int position) {

        if (head == null) {
            return;
        }

        Node tmp = head;
        if (position == 0) {
            head = tmp.next;
            return;
        }

        //每比较一次，tmp 前进一步，比较postion-1次
        for (int i = 0; tmp != null && i < position - 1; i++) {
            tmp = tmp.next;
        }

        //多余
        if (tmp == null || tmp.next == null) {
            return;
        }

        Node next = tmp.next.next;
        tmp.next = next;

    }

    public void push(int data) {

        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void print() {

        Node n = head;
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println();
    }


}
