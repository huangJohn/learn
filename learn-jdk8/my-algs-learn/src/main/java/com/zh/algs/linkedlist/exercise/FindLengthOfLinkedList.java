package com.zh.algs.linkedlist.exercise;

import com.zh.algs.test.linkedlist.ListNodeUtil;
import com.zh.algs.test.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class FindLengthOfLinkedList {

    private Node head;


    public static void main(String[] args) {

        FindLengthOfLinkedList test = new FindLengthOfLinkedList();

        test.head = ListNodeUtil.push(test.head, 1);
        test.head = ListNodeUtil.push(test.head, 2);
        test.head = ListNodeUtil.push(test.head, 3);
        test.head = ListNodeUtil.push(test.head, 4);
        test.head = ListNodeUtil.push(test.head, 5);

        ListNodeUtil.print(test.head);

        System.out.println(test.findByIter());
        System.out.println(test.findByRecur());

    }

    public int findByRecur() {
        return findByRecurInner(head);
    }

    private int findByRecurInner(Node head) {

        if (head == null) {
            return 0;
        }
        return 1 + findByRecurInner(head.next);
    }


    public int findByIter() {

        int count = 0;

        Node tmp = head;

        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        return count;
    }

}
