package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class FindMiddleNodeOfLinkedList {


    private Node head = ListNodeUtil.createHeadByAppend();


    public static void main(String[] args) {

        FindMiddleNodeOfLinkedList test = new FindMiddleNodeOfLinkedList();
        ListNodeUtil.print(test.head);

        System.out.println(test.findMiddleNode());

        test.head = ListNodeUtil.createHeadByAppend2();
        ListNodeUtil.print(test.head);

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
