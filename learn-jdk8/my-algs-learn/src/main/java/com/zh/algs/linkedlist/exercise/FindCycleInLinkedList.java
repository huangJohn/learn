package com.zh.algs.linkedlist.exercise;

import com.zh.algs.test.linkedlist.ListNodeUtil;
import com.zh.algs.test.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/17
 */
public class FindCycleInLinkedList {

    private Node head;

    public static void main(String[] args) {

        FindCycleInLinkedList test = new FindCycleInLinkedList();
        test.head = ListNodeUtil.createCircle();
        System.out.println(test.findIsCycle());
        System.out.println(test.findCycleEntrance());
    }


    public int findIsCycle() {

        Node fast_ptr = head, slow_ptr = head;

        while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;

            if (slow_ptr == fast_ptr) {
                return getCycleLength(slow_ptr);
            }
        }

        return 0;

    }


    public int findCycleEntrance() {

        Node fast_ptr = head, slow_ptr = head;

        while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;

            if (slow_ptr == fast_ptr) {
                break;
            }
        }

        if (slow_ptr != fast_ptr) {
            return 0;
        }

        slow_ptr = head;

        while (slow_ptr != fast_ptr) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
        }

        return slow_ptr.data;

    }


    public int getCycleLength(Node slow_ptr) {

        Node tmp = slow_ptr;
        int count = 1;

        while (tmp.next != slow_ptr) {
            count++;
            tmp = tmp.next;
        }

        return count;

    }


}
