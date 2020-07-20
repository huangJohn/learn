package com.zh.algs.ds.exercise.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/20
 */
public class RemoveDupNodesInSortedLinkedList {


    private Node head;

    public static void main(String[] args) {

        RemoveDupNodesInSortedLinkedList test = new RemoveDupNodesInSortedLinkedList();
        test.head = ListNodeUtil.createHeadByAppend4();
        ListNodeUtil.print(test.head);

        test.removeDup();
        ListNodeUtil.print(test.head);

    }


    public void removeDup() {

        Node cur = head;

        while (cur != null) {
            Node tmp = cur;
            while (tmp != null && tmp.data == cur.data) {
                tmp = tmp.next;
            }

            cur.next = tmp;
            cur = cur.next;
        }
    }




}
