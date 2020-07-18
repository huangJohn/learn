package com.zh.algs.ds.linkedlist;

import java.util.StringJoiner;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/15
 */
public class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("next=" + next)
                .toString();
    }
}
