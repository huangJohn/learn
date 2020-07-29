package com.zh.algs.interview.top.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/29
 */
public class MergeSort {

    private Node head;

    public static void main(String[] args) {

        MergeSort test = new MergeSort();
        test.head = ListNodeUtil.push(test.head, 1);
        test.head = ListNodeUtil.push(test.head, 10);
        test.head = ListNodeUtil.push(test.head, 8);
        test.head = ListNodeUtil.push(test.head, 7);
        test.head = ListNodeUtil.push(test.head, 4);
        ListNodeUtil.print(test.head);

        test.head = test.mergeSort(test.head);
        ListNodeUtil.print(test.head);
    }

    public Node mergeSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node middle_next = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(middle_next);

        Node sorted = sortedMerge(left, right);

        return sorted;

    }

    private Node sortedMerge(Node left, Node right) {

        Node res = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.data <= right.data) {
            res = left;
            res.next = sortedMerge(left.next, right);
        } else {
            res = right;
            res.next = sortedMerge(left, right.next);
        }
        return res;
    }

    public Node getMiddle(Node head) {

        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        /**
         * Description:
         * 2步判断，middle落到前节点，否则1步判断，落到后节点，会产生死循环，stack溢出ex
         */
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
