package com.zh.algs.interview.top.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * head 是高位
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/28
 */
public class Add2Nums2 {

    private Node head1;
    private Node head2;

    private int carry = 0;
    private Node result;

    private Node prev;

    public static void main(String[] args) {

        Add2Nums2 test = new Add2Nums2();
        test.head1 = ListNodeUtil.push(test.head1, 9);
        test.head1 = ListNodeUtil.push(test.head1, 9);
        test.head1 = ListNodeUtil.push(test.head1, 9);
        test.head2 = ListNodeUtil.push(test.head2, 1);
        test.head2 = ListNodeUtil.push(test.head2, 8);
        ListNodeUtil.print(test.head1);
        ListNodeUtil.print(test.head2);
        test.addTwo2();
        ListNodeUtil.print(test.result);


    }

    public void addTwo2() {

        if (head1 == null) {
            result = head2;
            return;
        }

        if (head2 == null) {
            result = head1;
            return;
        }

        int size1 = getSize(head1);
        int size2 = getSize(head2);

        if (size1 == size2) {
            addSameLists(head1, head2);
        }

        if (size1 < size2) {
            Node tmp = head1;
            head1 = head2;
            head2 = tmp;
        }

        int diff = Math.abs(size1 - size2);

        Node tmp = head1;
        while (diff >= 0) {
            diff = diff - 1;
            prev = tmp;
            tmp = tmp.next;
        }

        addSameLists(prev, head2);

        propogateCarry(head1);

        if (carry > 0) {
            push(carry);
        }

    }

    private void propogateCarry(Node head1) {

        if (head1 != prev) {
            propogateCarry(head1.next);
            int sum = carry + head1.data;
            carry = sum / 10;
            sum = sum % 10;
            push(sum);
        }
    }


    public void addSameLists(Node head1, Node head2) {

        if (head1 == null) {
            return;
        }

        addSameLists(head1.next, head2.next);

        int sum = carry + head1.data + head2.data;
        carry = sum / 10;
        sum = sum % 10;

        push(sum);

    }

    public void push(int x) {

        Node xNode = new Node(x);
        if (result == null) {
            result = xNode;
            return;
        }

        xNode.next = result;
        result = xNode;
    }


    private int getSize(Node head1) {
        int count = 0;
        Node cur1 = head1;
        while (cur1 != null) {
            count++;
            cur1 = cur1.next;
        }
        return count;
    }
}
