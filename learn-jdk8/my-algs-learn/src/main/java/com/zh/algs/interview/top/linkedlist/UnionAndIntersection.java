package com.zh.algs.interview.top.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/29
 */
public class UnionAndIntersection {

    private Node head1;
    private Node head2;

    private Node union;
    private Node intersection;

    public static void main(String[] args) {

        UnionAndIntersection test = new UnionAndIntersection();
        test.head1 = ListNodeUtil.push(test.head1, 1);
        test.head1 = ListNodeUtil.push(test.head1, 2);
        test.head1 = ListNodeUtil.push(test.head1, 3);
        test.head1 = ListNodeUtil.push(test.head1, 4);
        test.head2 = ListNodeUtil.push(test.head2, 1);
        test.head2 = ListNodeUtil.push(test.head2, 5);
        test.head2 = ListNodeUtil.push(test.head2, 3);
        test.head2 = ListNodeUtil.push(test.head2, 6);
        ListNodeUtil.print(test.head1);
        ListNodeUtil.print(test.head2);

        test.findUnion();
        ListNodeUtil.print(test.union);

        test.findIntersection();
        ListNodeUtil.print(test.intersection);

    }

    public void findIntersection() {
        Node temp1 = head1;
        while (temp1 != null) {
            if (isPresentInHead2(temp1)) {
                intersection = ListNodeUtil.push(intersection, temp1.data);
            }
            temp1 = temp1.next;
        }
    }

    private boolean isPresentInHead2(Node temp1) {
        Node cur = head2;
        while (cur != null) {
            if (cur.data == temp1.data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    public void findUnion() {

        Node temp1 = head1;
        while (temp1 != null) {
            union = ListNodeUtil.push(union, temp1.data);
            temp1 = temp1.next;
        }

        Node temp2 = head2;
        while (temp2 != null) {
            if (!isPresent(temp2)) {
                union = ListNodeUtil.push(union, temp2.data);
            }
            temp2 = temp2.next;
        }



    }

    private boolean isPresent(Node temp2) {

        Node cur = head1;
        while (cur != null) {
            if (cur.data == temp2.data) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


}
