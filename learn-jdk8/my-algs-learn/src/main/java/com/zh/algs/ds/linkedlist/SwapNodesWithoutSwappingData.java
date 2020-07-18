package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/18
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

        /**
         * Description:
         * 1 2  3  4     5    6  7 8    (3,6)
         *   px cx t      py  cy
         */

        Node prevX = null, currentX = head;
        while (currentX != null) {
            if (currentX.data == x) {
                break;
            }
            prevX = currentX;
            currentX = currentX.next;
        }

        Node prevY = null, currentY = head;
        while (currentY != null) {
            if (currentY.data == y) {
                break;
            }
            prevY = currentY;
            currentY = currentY.next;
        }

        if (currentX == null || currentY == null) {
            return;
        }

        if (prevX != null) {
            prevX.next = currentY;
        } else {
            head = currentY;
        }



        if (prevY != null) {
            prevY.next = currentX;
        } else {
            head = currentX;
        }

        Node tmp = currentX.next;//4
        currentX.next = currentY.next;//3 -> 7
        currentY.next = tmp;// 6 -> 4

    }

}
