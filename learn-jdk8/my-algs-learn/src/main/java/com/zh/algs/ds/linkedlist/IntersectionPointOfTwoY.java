package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/18
 */
public class IntersectionPointOfTwoY {

    private Node head1;
    private Node head2;

    public static void main(String[] args) {
        IntersectionPointOfTwoY test = new IntersectionPointOfTwoY();
        test.head1 = ListNodeUtil.createHeadByAppend5();
        test.head2 = ListNodeUtil.createHeadByAppend6();
        ListNodeUtil.print(test.head1);
        ListNodeUtil.print(test.head2);

        System.out.println(test.getPoint());

    }

    public int getPoint() {

        int count1 = getCount(head1);
        int count2 = getCount(head2);

        int d = 0;

        if (count1 > count2) {
            d = count1 - count2;
            return _point(d, head1, head2);
        } else {
            d = count2 - count1;
            return _point(d, head2, head1);
        }
    }


    public int getCount(Node head) {

        Node cur = head;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }


    public int _point(int d, Node node1, Node node2) {

        int i;
        Node current1 = node1;
        Node current2 = node2;

        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }

        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1.data;
            } else {
                current1 = current1.next;
                current2 = current2.next;
            }
        }
        return -1;
    }

}
