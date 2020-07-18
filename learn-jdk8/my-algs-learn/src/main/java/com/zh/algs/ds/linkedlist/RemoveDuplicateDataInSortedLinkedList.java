package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/18
 */
public class RemoveDuplicateDataInSortedLinkedList {

    private Node head;

    public static void main(String[] args) {

        RemoveDuplicateDataInSortedLinkedList test = new RemoveDuplicateDataInSortedLinkedList();
        test.head = ListNodeUtil.createHeadByAppend4();
        ListNodeUtil.print(test.head);

        test.removeDuplicate();
        ListNodeUtil.print(test.head);


    }


    public void removeDuplicate() {

        Node current = head;

        while (current != null) {

            Node tmp = current;

            /**
             * Description:
             * 1 - 1 - 1 - 2 - 2 - 3 - 4 - 4 - 5 - 6
             * c
             *             t
             *             c
             * 1 - 2 - 2 - 3 - 4 - 4 - 5 - 6
             *     c
             *     t
             *             t
             *             c
             * 1 - 2 - 3 - 4 - 4 - 5 - 6
             *         c
             *         t
             *             c
             *             t
             */
            while (tmp != null && tmp.data == current.data) {
                tmp = tmp.next;
            }

            current.next = tmp;
            current = current.next;
        }

    }

}
