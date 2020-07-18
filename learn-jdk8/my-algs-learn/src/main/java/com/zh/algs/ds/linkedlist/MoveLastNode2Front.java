package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/18
 */
public class MoveLastNode2Front {

    private Node head;

    public static void main(String[] args) {

        MoveLastNode2Front front = new MoveLastNode2Front();
        front.head = ListNodeUtil.createHeadByAppend3();
        ListNodeUtil.print(front.head);

        front.moveLast();
        ListNodeUtil.print(front.head);
    }

    /**
     * Description:
     * 1 2 3 4 5
     * 5 1 2 3 4
     */
    public void moveLast() {

        if (head == null || head.next == null) {
            return;
        }

        Node last = head;
        Node secLast = null;

        while (last.next != null) {
            secLast = last;
            last = last.next;
        }

        secLast.next = null;
        last.next = head;
        head = last;



    }

}
