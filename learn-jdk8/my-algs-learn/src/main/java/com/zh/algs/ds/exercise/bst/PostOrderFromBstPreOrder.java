package com.zh.algs.ds.exercise.bst;

import com.zh.algs.ds.binarytree.TreeNode;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/23
 */

class Index {
    public int index = 0;
}

public class PostOrderFromBstPreOrder {


    private TreeNode root;
    Index index = new Index();

    public static void main(String[] args) {

        int[] pre = new int[]{10, 5, 1, 7, 40, 50};
        PostOrderFromBstPreOrder test = new PostOrderFromBstPreOrder();
        test.root = test.constructTree(pre, pre.length);

        test.inOrder(test.root);
        System.out.println();

        test.postOrder(test.root);
        System.out.println();


    }

    public void inOrder(TreeNode root) {
        if (root==null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " -> ");
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root==null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " -> ");
    }

    public TreeNode constructTree(int[] arr, int size) {
        return constructTreeUtil(arr, 0, size - 1, size, index);
    }

    public TreeNode constructTreeUtil(int[] arr, int low, int high, int size, Index preIdx) {

        if (preIdx.index >= size || low > high) {
            return null;
        }

        TreeNode root = new TreeNode(arr[preIdx.index]);
        preIdx.index = preIdx.index + 1;

        if (low == high) {
            return root;
        }

        int i = 0;
        for (i = low; i <= high; i++) {
            if (arr[i] > root.data) {
                break;
            }
        }

        root.left = constructTreeUtil(arr, preIdx.index, i - 1, size, preIdx);
        root.right = constructTreeUtil(arr, i, high, size, preIdx);
        return root;
    }

}
