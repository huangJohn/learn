package com.zh.algs.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class FindCycleInLinkedList {

    private Node head;

    public static void main(String[] args) {

        FindCycleInLinkedList test = new FindCycleInLinkedList();
        test.head = ListNodeUtil.createHeadByAppend();

        Node tmp = test.head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = test.head.next;

        System.out.println(test.findByPtr());

    }


    public boolean findByPtr() {

        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;

    }

    public boolean findCycleByHash() {

        Set<Integer> set = new HashSet<>();
        Node cur = head;

        while (cur != null) {

            if (!set.contains(cur.data)) {
                set.add(cur.data);
                cur = cur.next;
            } else {
                return true;
            }

        }

        return false;

    }


}
