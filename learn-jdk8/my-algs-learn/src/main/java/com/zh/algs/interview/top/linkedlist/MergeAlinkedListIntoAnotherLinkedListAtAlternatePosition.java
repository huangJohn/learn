package com.zh.algs.interview.top.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/29
 */
public class MergeAlinkedListIntoAnotherLinkedListAtAlternatePosition {

    private Node head;

    private Node anotherHead;


    public static void main(String[] args) {
        MergeAlinkedListIntoAnotherLinkedListAtAlternatePosition test = new MergeAlinkedListIntoAnotherLinkedListAtAlternatePosition();

        test.head = ListNodeUtil.push(test.head, 1);
        test.head = ListNodeUtil.push(test.head, 3);
        test.head = ListNodeUtil.push(test.head, 5);
        test.head = ListNodeUtil.push(test.head, 7);

        test.anotherHead = ListNodeUtil.push(test.anotherHead, 2);
        test.anotherHead = ListNodeUtil.push(test.anotherHead, 4);
        test.anotherHead = ListNodeUtil.push(test.anotherHead, 6);
        test.anotherHead = ListNodeUtil.push(test.anotherHead, 8);
        test.anotherHead = ListNodeUtil.push(test.anotherHead, 10);

        ListNodeUtil.print(test.head);
        ListNodeUtil.print(test.anotherHead);

        test.merge();

        ListNodeUtil.print(test.head);
        ListNodeUtil.print(test.anotherHead);
    }


    public void merge() {

        Node first = head;
        Node second = anotherHead;
        Node first_next = null;
        Node second_next = null;

        while (first != null && second != null) {

            first_next = first.next;
            second_next = second.next;

            first.next = second;
            second.next = first_next;

            first = first_next;
            second = second_next;
        }

        anotherHead = second;
    }

}
