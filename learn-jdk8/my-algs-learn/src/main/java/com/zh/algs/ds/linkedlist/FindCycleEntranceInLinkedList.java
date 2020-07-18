package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class FindCycleEntranceInLinkedList {

    private Node head;

    public static void main(String[] args) {

        FindCycleEntranceInLinkedList test = new FindCycleEntranceInLinkedList();
        test.head = ListNodeUtil.createHeadByAppend();

        Node tmp = test.head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = test.head.next.next;

        System.out.println(test.findCycleEntrance());

    }

    public int findCycleEntrance() {

        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return -1;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;


    }

}
