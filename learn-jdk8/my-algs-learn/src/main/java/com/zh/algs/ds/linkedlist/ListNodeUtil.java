package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/15
 */
public class ListNodeUtil {


    public static Node createHeadByAppend() {
        Node node = new Node(1);
        node = append(node, 2);
        node = append(node, 3);
        node = append(node, 4);
        node = append(node, 5);
        node = append(node, 6);
        return node;
    }

    public static Node createHeadByAppend2() {
        Node node = new Node(1);
        node = append(node, 2);
        node = append(node, 3);
        node = append(node, 4);
        node = append(node, 5);
        node = append(node, 6);
        node = append(node, 7);
        return node;
    }

    public static Node createHeadByAppend3() {
        Node node = new Node(1);
        node = append(node, 2);
        node = append(node, 1);
        node = append(node, 4);
        node = append(node, 1);
        node = append(node, 6);
        node = append(node, 1);
        return node;
    }

    public static Node createHeadByAppend4Palindrome() {
        Node node = new Node(1);
        node = append(node, 2);
        node = append(node, 3);
        node = append(node, 4);
        node = append(node, 3);
        node = append(node, 2);
        node = append(node, 1);
        return node;
    }

    public static Node createHeadByAppend4Palindrome2() {
        Node node = new Node(1);
        node = append(node, 2);
        node = append(node, 3);
        node = append(node, 3);
        node = append(node, 2);
        node = append(node, 1);
        return node;
    }


    public static Node createCircle() {

        Node node = new Node(1);
        node = append(node, 2);
        node = append(node, 3);
        node = append(node, 4);
        node = append(node, 5);
        node = append(node, 6);
        node = append(node, 7);

        Node last = node;
        while (last.next != null) {
            last = last.next;
        }

        last.next = node.next.next;

        return node;
    }

    public static Node createHeadByPush() {
        Node node = new Node(1);
        node = push(node, 2);
        node = push(node, 3);
        node = push(node, 4);
        node = push(node, 5);
        node = push(node, 6);
        return node;
    }

    public static void print(Node head) {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.getData() + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static int findNthNode(Node head, int n) {

        Node tmp = head;

        int count = 0;

        while (tmp != null) {
            if (count == n) {
                return tmp.data;
            }

            count++;
            tmp = tmp.next;
        }

        assert false;
        return 0;

    }

    public static int findLength(Node head) {

        Node tmp = head;
        int count = 0;

        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        return count;
    }

    public static Node push(Node head, int data) {

        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    public static Node append(Node head, int data) {

        Node node = new Node(data);
        if (head == null) {
            head = node;
            return head;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        return head;
    }

    public static void insertAfter(Node node, int data) {

        if (node == null) {
            throw new RuntimeException("insertAfter: prev node can't be null");
        }

        Node node1 = new Node(data);
        node1.next = node.next;
        node.next = node1;
    }

}
