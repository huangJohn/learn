package com.zh.algs.linkedlist.exercise;

import com.zh.algs.test.linkedlist.ListNodeUtil;
import com.zh.algs.test.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class DeleteANodeByGivenPosition {

    private Node head;

    public static void main(String[] args) {

        DeleteANodeByGivenPosition test = new DeleteANodeByGivenPosition();

        test.append(1);
        test.append(2);
        test.append(3);
        test.append(4);
        ListNodeUtil.print(test.head);

        test.deleteByGivenPosition(4);
        ListNodeUtil.print(test.head);

        test.deleteByGivenPosition(0);
        ListNodeUtil.print(test.head);

        test.deleteByGivenPosition(1);
        ListNodeUtil.print(test.head);
    }

    public void append(int data) {

        Node n = new Node(data);
        if (head == null) {
            head = n;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = n;
    }

    public void deleteByGivenPosition(int position) {

        if (head == null) {
            return;
        }

        Node tmp = head;

        if (position == 0) {
            head = tmp.next;
            return;
        }

        for (int i = 0; tmp != null && i < position - 1; i++) {
            tmp = tmp.next;
        }

        if (tmp == null || tmp.next == null) {
            //1 - 2 - 3 - 4
            //0   1   2   3  4
            //tmp.next null 尾节点下个位置
            return;
        }

        tmp.next = tmp.next.next;

    }

}
