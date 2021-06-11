package com.zh.algs.ds.doublelinkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2021/3/8
 */
public class Node {

    public int data;

    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
