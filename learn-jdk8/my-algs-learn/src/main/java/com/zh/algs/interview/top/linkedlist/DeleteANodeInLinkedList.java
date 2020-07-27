package com.zh.algs.interview.top.linkedlist;

import com.zh.algs.ds.linkedlist.DeleteANodeByData;
import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/28
 */
public class DeleteANodeInLinkedList {

    private Node head;

    public static void main(String[] args) {
        DeleteANodeInLinkedList deleteANodeByData = new DeleteANodeInLinkedList();
        deleteANodeByData.head = ListNodeUtil.push(deleteANodeByData.head, 1);
        deleteANodeByData.head = ListNodeUtil.push(deleteANodeByData.head, 2);
        deleteANodeByData.head = ListNodeUtil.push(deleteANodeByData.head, 3);
        ListNodeUtil.print(deleteANodeByData.head);

        deleteANodeByData.deleteANode(2);
        ListNodeUtil.print(deleteANodeByData.head);
        deleteANodeByData.deleteANode(4);
        ListNodeUtil.print(deleteANodeByData.head);
        deleteANodeByData.deleteANode(3);
        ListNodeUtil.print(deleteANodeByData.head);

        deleteANodeByData.head = ListNodeUtil.push(deleteANodeByData.head, 5);
        ListNodeUtil.print(deleteANodeByData.head);
        deleteANodeByData.deleteANode(5);
        ListNodeUtil.print(deleteANodeByData.head);
    }

    public void deleteANode(int key) {

        Node tmp = head;

        if (tmp != null && tmp.data == key) {
            head = tmp.next;
            return;
        }

        Node prev = null;
        while (tmp != null && tmp.data != key) {
            prev = tmp;
            tmp = tmp.next;
        }

        if (tmp == null) {
            return;
        }

        prev.next = tmp.next;
        tmp.next = null;
    }


}
