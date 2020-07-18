package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/18
 */
public class IntersectionOfTwoSorted {

    private Node head1;
    private Node head2;

    public static void main(String[] args) {

        IntersectionOfTwoSorted intersectionOfTwoSorted = new IntersectionOfTwoSorted();
        intersectionOfTwoSorted.head1 = ListNodeUtil.createHeadByAppend();
        intersectionOfTwoSorted.head2 = ListNodeUtil.createHeadByAppend4();
        ListNodeUtil.print(intersectionOfTwoSorted.head1);
        ListNodeUtil.print(intersectionOfTwoSorted.head2);
        ListNodeUtil.print(intersectionOfTwoSorted.intersection(intersectionOfTwoSorted.head1, intersectionOfTwoSorted.head2));
    }

    public Node intersection(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            return null;
        }

        Node head = new Node(-1);
        Node p = head;

        /**
         * Description:
         * 1 2 3 4 5
         * 1 3 4
         */
        while (node1 != null && node2 != null) {
            if (node1.data == node2.data) {
                p.next = node1;
                node1 = node1.next;
                node2 = node2.next;
                p = p.next;
            } else if (node1.data < node2.data) {
                node1 = node1.next;
            } else {
                node2 = node2.next;
            }
        }

        p.next = null;
        return head.next;

    }

}
