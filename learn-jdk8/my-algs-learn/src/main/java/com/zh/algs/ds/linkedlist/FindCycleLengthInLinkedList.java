package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class FindCycleLengthInLinkedList {

    private Node head;

    public static void main(String[] args) {

        FindCycleLengthInLinkedList test = new FindCycleLengthInLinkedList();
        test.head = ListNodeUtil.createHeadByAppend();

        Node tmp = test.head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = test.head.next;

        System.out.println(test.getCycleLength());

    }

    public int getCycleLength() {

        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return getLength(slow);
            }
        }
        return -1;
    }

    private int getLength(Node slow) {

        int count = 1;
        Node tmp = slow;

        while (tmp.next != slow) {
            tmp = tmp.next;
            count++;
        }

        return count;
    }


}
