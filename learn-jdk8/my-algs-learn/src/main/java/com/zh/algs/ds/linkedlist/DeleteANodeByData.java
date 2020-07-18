package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/15
 */
public class DeleteANodeByData {

    private Node head;

    public static void main(String[] args) {


        DeleteANodeByData deleteANodeByData = new DeleteANodeByData();
        deleteANodeByData.head = ListNodeUtil.push(deleteANodeByData.head, 1);
        deleteANodeByData.head = ListNodeUtil.push(deleteANodeByData.head, 2);
        deleteANodeByData.head = ListNodeUtil.push(deleteANodeByData.head, 3);
        ListNodeUtil.print(deleteANodeByData.head);

        deleteANodeByData.deleteByData(2);
        ListNodeUtil.print(deleteANodeByData.head);
        deleteANodeByData.deleteByData(4);
        ListNodeUtil.print(deleteANodeByData.head);
        deleteANodeByData.deleteByData(3);
        ListNodeUtil.print(deleteANodeByData.head);

        deleteANodeByData.head = ListNodeUtil.push(deleteANodeByData.head, 5);
        ListNodeUtil.print(deleteANodeByData.head);
        deleteANodeByData.deleteByData(5);
        ListNodeUtil.print(deleteANodeByData.head);
    }

    public void deleteByData(int data) {

        Node tmp = head;

        //if head is to be deleted
        if (tmp != null && tmp.data == data) {
            head = tmp.next;
            return;
        }

        //if not, we should record prev node
        Node prev = null;

        //find data
        while (tmp != null && tmp.data != data) {
            prev = tmp;//每次移步前需要记录前节点
            tmp = tmp.next;
        }

        //result: if tmp arrives tail then not find the data
        if (tmp == null) {
            return;
        }

        //result: find the data
        prev.next = tmp.next;
        tmp.next = null;

    }

}
