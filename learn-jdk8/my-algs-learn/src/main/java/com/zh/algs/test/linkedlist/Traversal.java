package com.zh.algs.test.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/15
 */
public class Traversal {

    private Node head;


    public void print() {

        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.getData() + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Traversal traversal = new Traversal();
        traversal.head = new Node(1);
        traversal.head.next = new Node(2);

//        traversal.print();
        ListNodeUtil.print(traversal.head);




    }


}
