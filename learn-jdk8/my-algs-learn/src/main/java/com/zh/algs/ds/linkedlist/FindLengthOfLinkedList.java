package com.zh.algs.ds.linkedlist;

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

        ListNodeUtil.print(test.head);

        System.out.println(test.findLength());
        System.out.println(test.findLengthByRecursive());



    }

    public int findLengthByRecursive() {
        return findRecur(head);
    }

    private int findRecur(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + findRecur(node.next);
    }


    public int findLength() {

        int count = 0;

        Node t = head;

        while (t != null) {
            count++;
            t = t.next;
        }

        return count;

    }

}
