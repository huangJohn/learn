package com.zh.algs.ds.exercise.binarytree;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/23
 */
public class PostOrderByInOrderAndPreOrder {

    public static void main(String[] args) {


        int in[] = new int[]{4, 2, 5, 1, 3, 6};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};

        PostOrderByInOrderAndPreOrder test = new PostOrderByInOrderAndPreOrder();
        test.postWithoutConstructTree(in, pre, in.length);

    }


    public void postWithoutConstructTree(int[] in, int[] pre, int size) {

        int root = searchInInOrderArray(in, pre[0], size);

        if (root != 0) {
            postWithoutConstructTree(in, Arrays.copyOfRange(pre, 1, size), root);
        }

        if (root != size - 1) {
            postWithoutConstructTree(Arrays.copyOfRange(in, root + 1, size), Arrays.copyOfRange(in, root + 1, size), size - root - 1);
        }

        System.out.print(pre[0] + " -> ");

    }

    public int searchInInOrderArray(int[] in, int x, int size) {

        int i = 0;
        for (i = 0; i < size; i++) {
            if (in[i] == x) {
                return i;
            }
        }
        return -1;
    }


}
