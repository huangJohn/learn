package com.zh.algs.interview.top.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class RotateKthNodeALinkedList {

    private Node head;

    public static void main(String[] args) {
        RotateKthNodeALinkedList test = new RotateKthNodeALinkedList();
        test.head = ListNodeUtil.createHeadByAppend2();
        ListNodeUtil.print(test.head);
        test.rotate(5);
        ListNodeUtil.print(test.head);
    }

    public void rotate(int k) {

        if (k == 0) {
            return;
        }

        Node cur = head;
        int count = 1;
        //find kth
        while (count < k && cur != null) {
            count++;
            cur = cur.next;
        }

        //k大于长度或等于长度
        if (cur == null) {
            return;
        }

        Node kThNode = cur;

        //find last
        while (cur.next != null) {
            cur = cur.next;
        }

        //last -> head
        cur.next = head;
        //move head
        head = kThNode.next;
        //set null
        kThNode.next = null;
    }

}
