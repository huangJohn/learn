package com.zh.algs.ds.exercise.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class DeleteANodeByData {

    private Node head;

    public static void main(String[] args) {

        DeleteANodeByData test = new DeleteANodeByData();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);

        ListNodeUtil.print(test.head);

        test.deleteByData(5);
        ListNodeUtil.print(test.head);

        test.deleteByData(3);
        ListNodeUtil.print(test.head);
    }

    public void deleteByData(int data) {

        Node tmp = head;

        if (tmp != null && tmp.data == data) {
            head = tmp.next;
            return;
        }

        Node prev = null;

        while (tmp != null && tmp.data != data) {
            prev = tmp;
            tmp = tmp.next;
        }

        if (tmp == null) {
            return;
        }

        prev.next = tmp.next;
        tmp.next = null;
    }

    public void push(int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

}
