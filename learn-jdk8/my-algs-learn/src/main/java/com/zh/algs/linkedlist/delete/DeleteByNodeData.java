package com.zh.algs.linkedlist.delete;

import org.slf4j.MDC;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/7
 */
public class DeleteByNodeData {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;


    public void deleteNodeByNodeData(int data) {

        Node tmp = head;

        //头指针就是要删除的data
        if (tmp != null && tmp.data == data) {
            head = tmp.next;
            return;
        }

        Node prev = null;

        //找到和data相同的节点，记录前一个节点prev
        while (tmp != null && tmp.data != data) {
            prev = tmp;
            tmp = tmp.next;
        }

        //遍历到尾巴，没有，说明链表中无
        if (tmp == null) {
            return;
        }

        //有，删除data节点
        prev.next = tmp.next;

    }

    public static void main(String[] args) {
        DeleteByNodeData deleteByNodeData = new DeleteByNodeData();
        deleteByNodeData.append(1);
        deleteByNodeData.append(2);
        deleteByNodeData.print();

        deleteByNodeData.deleteNodeByNodeData(1);
        deleteByNodeData.print();
        deleteByNodeData.deleteNodeByNodeData(2);
        deleteByNodeData.print();

        deleteByNodeData.append(1);
        deleteByNodeData.append(2);
        deleteByNodeData.append(3);
        deleteByNodeData.print();
        deleteByNodeData.deleteNodeByNodeData(4);
        deleteByNodeData.print();
    }

    public void append(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void print() {

        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.println();
    }


}
