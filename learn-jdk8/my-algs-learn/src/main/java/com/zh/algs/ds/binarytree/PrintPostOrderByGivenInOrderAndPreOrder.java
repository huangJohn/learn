package com.zh.algs.ds.binarytree;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/21
 */
public class PrintPostOrderByGivenInOrderAndPreOrder {


    public static void main(String[] args) {
        PrintPostOrderByGivenInOrderAndPreOrder test = new PrintPostOrderByGivenInOrderAndPreOrder();
        int in[] = new int[]{4, 2, 5, 1, 3, 6};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        test.printPostOrder(in, pre, in.length);
    }


    public void printPostOrder(int in[], int pre[], int n) {

        int root = search(in, pre[0], n);

        if (root != 0) {
            printPostOrder(in, Arrays.copyOfRange(pre, 1, n), root);
        }

        if (root != n - 1) {
            printPostOrder(Arrays.copyOfRange(in, root + 1, n), Arrays.copyOfRange(pre, root + 1, n), n - root - 1);
        }

        System.out.print(pre[0] + " -> ");
    }

    public int search(int arr[], int x, int n) {

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }


}
