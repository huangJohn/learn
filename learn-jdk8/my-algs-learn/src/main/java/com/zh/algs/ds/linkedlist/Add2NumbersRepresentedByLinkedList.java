package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * head 是低位
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/28
 */
public class Add2NumbersRepresentedByLinkedList {

    private Node head1;
    private Node head2;

    public static void main(String[] args) {

        Add2NumbersRepresentedByLinkedList test = new Add2NumbersRepresentedByLinkedList();
        test.head1 = ListNodeUtil.push(test.head1, 1);
        test.head1 = ListNodeUtil.push(test.head1, 5);
        test.head1 = ListNodeUtil.push(test.head1, 7);
        test.head2 = ListNodeUtil.push(test.head2, 9);
        test.head2 = ListNodeUtil.push(test.head2, 9);
        test.head2 = ListNodeUtil.push(test.head2, 9);
        test.head2 = ListNodeUtil.push(test.head2, 7);

        ListNodeUtil.print(test.head1);
        ListNodeUtil.print(test.head2);

        ListNodeUtil.print(test.addTwo(test.head1, test.head2));
    }

    public Node addTwo(Node head1, Node head2) {

        Node cur1 = head1;
        Node cur2 = head2;

        Node tmp = null;
        Node result = null;
        Node prev = null;

        int carry = 0, sum = 0;

        while (cur1 != null || cur2 != null) {

            sum = carry + (cur1 != null ? cur1.data : 0) + (cur2 != null ? cur2.data : 0);
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;

            tmp = new Node(sum);

            if (result == null) {
                result = tmp;
            } else {
                prev.next = tmp;
            }

            prev = tmp;

            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }

        if (carry > 0) {
            tmp.next = new Node(carry);
        }

        return result;
    }

}
