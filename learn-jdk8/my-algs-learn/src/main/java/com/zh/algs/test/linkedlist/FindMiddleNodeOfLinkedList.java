package com.zh.algs.test.linkedlist;

import static com.zh.algs.test.linkedlist.ListNodeUtil.*;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class FindMiddleNodeOfLinkedList {


    private Node head = createHeadByAppend();


    public static void main(String[] args) {

        FindMiddleNodeOfLinkedList test = new FindMiddleNodeOfLinkedList();
        print(test.head);

        System.out.println(test.findMiddleNode());

        test.head = createHeadByAppend2();
        print(test.head);

        System.out.println(test.findMiddleNode());


    }


    public int findMiddleNode() {

        Node slow = head, fast = head;

        if (head == null) {
            return -1;
        }

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;

    }







}
