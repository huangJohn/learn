package com.zh.algs.interview.top.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/28
 */
public class Compare2StringsRepresentedAsLinkedList {

    private Node head1;
    private Node head2;

    public static void main(String[] args) {

        Compare2StringsRepresentedAsLinkedList test = new Compare2StringsRepresentedAsLinkedList();
        test.head1 = ListNodeUtil.push(test.head1, 1);
        test.head1 = ListNodeUtil.push(test.head1, 2);
        test.head1 = ListNodeUtil.push(test.head1, 3);

        test.head2 = ListNodeUtil.push(test.head2, 1);
        test.head2 = ListNodeUtil.push(test.head2, 2);
        test.head2 = ListNodeUtil.push(test.head2, 1);

        System.out.println(test.compare(test.head1, test.head2));
    }

    public int compare(Node head1, Node head2) {

        if (head1 == null && head2 == null) {
            return 0;
        }

        while (head1 != null && head2 != null && head1.data == head2.data) {
            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1 != null && head2 != null) {
            if (head1.data > head2.data) {
                return 1;
            } else {
                return -1;
            }
        }

        if (head1 != null && head2 == null) {
            return 1;
        }

        if (head2 != null && head1 == null) {
            return -1;
        }

        return 0;
    }

}
