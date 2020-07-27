package com.zh.algs.interview.top.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/28
 */
public class InsertANodeInSortedLinkedList {

    private Node head;

    public static void main(String[] args) {
        InsertANodeInSortedLinkedList test = new InsertANodeInSortedLinkedList();

        test.head = ListNodeUtil.append(test.head, 1);
        test.head = ListNodeUtil.append(test.head, 2);
        test.head = ListNodeUtil.append(test.head, 4);
        test.head = ListNodeUtil.append(test.head, 5);
        test.head = ListNodeUtil.append(test.head, 8);
        test.head = ListNodeUtil.append(test.head, 9);

        ListNodeUtil.print(test.head);

        test.insertInSorted(6);
        ListNodeUtil.print(test.head);

    }

    public void insertInSorted(int key) {

        Node node = new Node(key);

        if (head == null || head.data >= key) {
            node.next = head;
            head = node.next;
            return;
        }

        Node cur = head;
        while (cur.next != null && cur.next.data < key) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

}
