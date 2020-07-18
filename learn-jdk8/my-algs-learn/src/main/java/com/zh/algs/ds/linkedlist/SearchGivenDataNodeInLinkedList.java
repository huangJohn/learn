package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/17
 */
public class SearchGivenDataNodeInLinkedList {

    private Node head;

    public static void main(String[] args) {

        SearchGivenDataNodeInLinkedList test = new SearchGivenDataNodeInLinkedList();

        test.head = ListNodeUtil.createHeadByAppend();
        ListNodeUtil.print(test.head);

        System.out.println(test.IsSearchGivenData(2));
        System.out.println(test.searchByRecur(test.head, 2));
    }

    public boolean IsSearchGivenData(int data) {

        Node cur = head;

        while (cur != null) {
            if (cur.data == data) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    public boolean searchByRecur(Node node, int data) {

        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        return searchByRecur(node.next, data);
    }

}
