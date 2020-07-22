package com.zh.algs.ds.bst;

import com.zh.algs.ds.binarytree.TreeNode;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/22
 */

class Index {
    int index = 0;
}

public class ConstructBSTWithPreOrder {

    private TreeNode root;
    private TreeNode root2;
    Index index = new Index();

    public static void main(String[] args) {

        int[] pre = new int[]{10, 5, 1, 7, 40, 50};
        ConstructBSTWithPreOrder test = new ConstructBSTWithPreOrder();
        test.root = test.constructTree(pre, pre.length);
        test.inOder(test.root);
        System.out.println();

        test.index.index = 0;
        test.root2 = test.constructBstByRange(pre, pre.length);
        test.inOder(test.root2);
        System.out.println();

    }

    public void inOder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOder(root.left);
        System.out.print(root.data + " -> ");
        inOder(root.right);
    }

    public TreeNode constructTree(int[] pre, int size) {
        return constructBstUtil(pre, index, 0, size - 1, size);
    }


    public TreeNode constructBstUtil(int[] pre, Index preIndex, int low, int high, int size) {
        // Base case
        if (preIndex.index >= size || low > high) {
            return null;
        }

        // The first node in preorder traversal is root. So take the node at
        // preIndex from pre[] and make it root, and increment preIndex
        TreeNode root = new TreeNode(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;

        // If the current subarray has only one element, no need to recur
        if (low == high) {
            return root;
        }

        // Search for the first element greater than root
        int i;
        for (i = low; i <= high; ++i) {
            if (pre[i] > root.data) {
                break;
            }
        }

        // Use the index of element found in preorder to divide
        // preorder array in two parts. Left subtree and right subtree
        root.left = constructBstUtil(pre, preIndex, preIndex.index, i - 1, size);
        root.right = constructBstUtil(pre, preIndex, i, high, size);

        return root;
    }

    public TreeNode constructBstByRange(int[] pre, int size) {
        return constructBstByRangeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    public TreeNode constructBstByRangeUtil(int[] pre, Index preIndex, int key, int min, int max, int size) {
        if (preIndex.index >= size) {
            return null;
        }

        TreeNode root = null;

        if (key > min && key < max) {
            root = new TreeNode(key);
            preIndex.index = preIndex.index + 1;

            if (preIndex.index < size) {
                root.left = constructBstByRangeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
                root.right = constructBstByRangeUtil(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }
        return root;
    }

}


