package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/17
 */
public class ReverseLinkedList {


    private Node head;

    public static void main(String[] args) {

        ReverseLinkedList test = new ReverseLinkedList();

        test.head = ListNodeUtil.createHeadByAppend();

        ListNodeUtil.print(test.head);

        test.reverse();

        ListNodeUtil.print(test.head);


    }


    public void reverse() {

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


}
