package com.zh.algs.ds.bst;

import com.zh.algs.ds.binarytree.TreeNode;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/23
 */
public class PrintPostOrderFromBSTPreOrder {

    Index index = new Index();

    private TreeNode root;

    public static void main(String[] args) {

        int[] pre = new int[]{40, 30, 35, 80, 100};
        PrintPostOrderFromBSTPreOrder test = new PrintPostOrderFromBSTPreOrder();

        test.root = test.constructTree(pre, pre.length);
        test.printPost(test.root);
        System.out.println();



    }

    public void printPost(TreeNode root) {

        if (root == null) {
            return;
        }

        printPost(root.left);
        printPost(root.right);
        System.out.print(root.data + " -> ");
    }


    public TreeNode constructTree(int[] arr, int n) {
        return constructTreeUtil(arr, 0, n - 1, n, index);
    }

    public TreeNode constructTreeUtil(int[] arr, int low, int high, int n, Index preIdx) {

        if (preIdx.index >= n || low > high) {
            return null;
        }

        TreeNode root = new TreeNode(arr[preIdx.index]);
        preIdx.index = preIdx.index + 1;

        if (low == high) {
            return root;
        }

        //search
        int i = 0;
        for (i = low; i <= high; i++) {
            if (arr[i] > root.data) {
                break;
            }
        }

        root.left = constructTreeUtil(arr, preIdx.index, i - 1, n, preIdx);
        root.right = constructTreeUtil(arr, i, high, n, preIdx);

        return root;

    }



}
