package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/18
 */
public class PairwiseSwapData {


    private Node head;

    public static void main(String[] args) {

        PairwiseSwapData pairwiseSwapData = new PairwiseSwapData();

        pairwiseSwapData.head = ListNodeUtil.createHeadByAppend3();
        ListNodeUtil.print(pairwiseSwapData.head);

        pairwiseSwapData.swap();
        ListNodeUtil.print(pairwiseSwapData.head);
    }

    public void swap() {

        Node tmp = head;

        while (tmp != null && tmp.next != null) {

            int data = tmp.data;
            tmp.data = tmp.next.data;
            tmp.next.data = data;

            tmp = tmp.next.next;

        }
    }



}
