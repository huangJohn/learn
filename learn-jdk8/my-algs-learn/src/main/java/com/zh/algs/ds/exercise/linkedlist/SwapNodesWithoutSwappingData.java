package com.zh.algs.ds.exercise.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/20
 */
public class SwapNodesWithoutSwappingData {

    public static void main(String[] args) {
        SwapNodesWithoutSwappingData test = new SwapNodesWithoutSwappingData();
        test.head = ListNodeUtil.createHeadByAppend();
        ListNodeUtil.print(test.head);
        test.swapNodes(4, 7);
        ListNodeUtil.print(test.head);

        test.swapNodes(4, 6);
        ListNodeUtil.print(test.head);

        test.swapNodes(2, 5);
        ListNodeUtil.print(test.head);

        test.swapNodes(1, 4);
        ListNodeUtil.print(test.head);
    }

    private Node head;

    public void swapNodes(int x, int y) {

        if (x == y) {
            return;
        }

        Node prevX = null, curX = head;
        Node prevY = null, curY = head;

        while (curX != null) {
            if (curX.data == x) {
                break;
            }
            prevX = curX;
            curX = curX.next;
        }

        while (curY != null) {
            if (curY.data == y) {
                break;
            }
            prevY = curY;
            curY = curY.next;
        }

        if (curX == null || curY == null) {
            return;
        }

        if (prevX != null) {
            prevX.next = curY;
        } else {
            head = curY;
        }

        if (prevY != null) {
            prevY.next = curX;
        } else {
            head = curX;
        }

        Node tmp = curX.next;
        curX.next = curY.next;
        curY.next = tmp;

    }


}
