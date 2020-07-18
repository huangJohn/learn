package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/15
 */
public class InsertNode {

    private Node head;

    //压式
    public void push(int data) {

        Node node = new Node(data);

        node.next = head;
        head = node;
    }

    //追加式
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

    //指定位置式
    public void insertAfter(Node prev, int data) {

        if (prev == null) {
            throw new RuntimeException("insertAfter: prev node can't be null");
        }

        Node node1 = new Node(data);
        node1.next = prev.next;
        prev.next = node1;

    }

    public static void main(String[] args) {

        InsertNode insertNode = new InsertNode();

        insertNode.push(1);
        insertNode.print();
        insertNode.push(2);
        insertNode.print();
        insertNode.push(3);
        insertNode.print();
        System.out.println("**********push over********");

        insertNode = new InsertNode();
        insertNode.append(4);
        insertNode.print();
        insertNode.append(5);
        insertNode.print();
        insertNode.append(6);
        insertNode.print();
        System.out.println("**********append over********");


        insertNode = new InsertNode();
        insertNode.append(1);
        insertNode.append(2);
        insertNode.append(3);
        insertNode.print();
        insertNode.insertAfter(insertNode.head, 4);
//        insertNode.print();
        ListNodeUtil.print(insertNode.head);
        System.out.println("*********insert after over****");


        //toString
        System.out.println(insertNode.head.toString());

        insertNode = new InsertNode();
        insertNode.insertAfter(insertNode.head, 5);
        //throw ex
    }


    public void print() {

        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }

}
