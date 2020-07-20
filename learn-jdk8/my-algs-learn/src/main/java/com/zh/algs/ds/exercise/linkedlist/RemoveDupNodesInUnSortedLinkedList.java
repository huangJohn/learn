package com.zh.algs.ds.exercise.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/20
 */
public class RemoveDupNodesInUnSortedLinkedList {


    private Node head;

    public static void main(String[] args) {


        RemoveDupNodesInUnSortedLinkedList test = new RemoveDupNodesInUnSortedLinkedList();
        test.head = ListNodeUtil.createHeadByAppend3();
        ListNodeUtil.print(test.head);
        test.removeDup();
        ListNodeUtil.print(test.head);

        test.head = ListNodeUtil.createHeadByAppend3();
        ListNodeUtil.print(test.head);
        test.removeDupByHash();
        ListNodeUtil.print(test.head);
    }

    public void removeDupByHash() {

        Set<Integer> set = new HashSet<>();

        Node cur = head;
        Node prev = null;

        while (cur != null) {

            if (!set.contains(cur.data)) {
                set.add(cur.data);
                prev = cur;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }


    }

    public void removeDup() {

        Node ptr1 = head, ptr2 = null, dup = null;

        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr2.next.data == ptr1.data) {
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
