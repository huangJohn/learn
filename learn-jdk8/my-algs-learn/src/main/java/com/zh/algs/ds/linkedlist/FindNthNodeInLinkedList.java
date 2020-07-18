package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class FindNthNodeInLinkedList {


    private Node head;


    public static void main(String[] args) {

        FindNthNodeInLinkedList test = new FindNthNodeInLinkedList();
        test.head = ListNodeUtil.push(test.head, 1);
        test.head = ListNodeUtil.push(test.head, 2);
        test.head = ListNodeUtil.push(test.head, 3);
        test.head = ListNodeUtil.push(test.head, 4);
        ListNodeUtil.print(test.head);

        System.out.println(test.findNth(5));

    }

    public int findNth(int n) {

        Node tmp = head;
        int count = 0;

        while (tmp != null) {
            if (count == n) {
                return tmp.data;
            }

            count++;
            tmp = tmp.next;
        }

        assert false;
        return 0;
    }


}
