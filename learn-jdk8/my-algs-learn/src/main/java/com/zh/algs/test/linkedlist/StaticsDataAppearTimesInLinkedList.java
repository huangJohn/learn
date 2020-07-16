package com.zh.algs.test.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class StaticsDataAppearTimesInLinkedList {

    private Node head;

    private int freq;

    public static void main(String[] args) {

        StaticsDataAppearTimesInLinkedList test = new StaticsDataAppearTimesInLinkedList();
        test.head = ListNodeUtil.createHeadByAppend3();

        System.out.println(test.findAppearTimes(1));
        System.out.println(test.findAppearTimes(2));
        System.out.println(test.findAppearTimes(9));

        System.out.println(test.findAppearTimesByRecur(test.head, 1));
        test.clearFreq();
        System.out.println(test.findAppearTimesByRecur(test.head,2));
        test.clearFreq();
        System.out.println(test.findAppearTimesByRecur(test.head, 9));
        test.clearFreq();

    }

    public void clearFreq() {
        this.freq = 0;
    }

    public int findAppearTimesByRecur(Node node, int data) {

        if (node == null) {
            return freq;
        }

        if (node.data == data) {
            freq++;
        }

        return findAppearTimesByRecur(node.next, data);
    }

    public int findAppearTimes(int data) {

        Node cur = head;

        int count = 0;

        while (cur != null) {
            if (cur.data == data) {
                count++;
            }
            cur = cur.next;
        }

        return count;
    }

}
