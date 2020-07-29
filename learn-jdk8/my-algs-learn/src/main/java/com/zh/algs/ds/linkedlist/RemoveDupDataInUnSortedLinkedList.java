package com.zh.algs.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/18
 */
public class RemoveDupDataInUnSortedLinkedList {

    private Node head;

    public static void main(String[] args) {

        RemoveDupDataInUnSortedLinkedList test = new RemoveDupDataInUnSortedLinkedList();
        test.head = ListNodeUtil.createHeadByAppend3();
        ListNodeUtil.print(test.head);
        test.removeByTwoLoops();
        ListNodeUtil.print(test.head);

        test.head = ListNodeUtil.createHeadByAppend3();
        ListNodeUtil.print(test.head);
        test.removeByHash();
        ListNodeUtil.print(test.head);

    }

    public void removeByHash() {

        Set<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {

            if (set.contains(current.data)) {
                prev.next = current.next;
            } else {
                prev = current;
                set.add(current.data);
            }

            current = current.next;
        }
    }


    public void removeByTwoLoops() {

        Node ptr1 = null, ptr2 = null, dup = null;

        ptr1 = head;

        /**
         * Description:
         * 4  1  2  1  4   1   3    3     2
         * a
         * b
         *    b
         *       b
         *          b  =   b
         *             b
         * 4  1  2   1  1  3   3    2
         */

        while (ptr1 != null && ptr1.next != null) {

            ptr2 = ptr1;

            while (ptr2.next != null) {
                if (ptr1.data == ptr2.next.data) {
                    ptr2.next = ptr2.next.next;
                    dup = ptr2.next;
                    System.gc();
                } else {
                    ptr2 = ptr2.next;
                }
            }

            ptr1 = ptr1.next;

        }

    }

}
