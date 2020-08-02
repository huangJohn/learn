package com.zh.algs.interview.top.tree;

import com.zh.algs.ds.binarytree.TreeNode;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/30
 */

class Max {
    int val;
}
public class MaxPathSumInTree {

    private TreeNode root;

    private Max max;

    public static void main(String[] args) {

        MaxPathSumInTree test = new MaxPathSumInTree();
        test.root = new TreeNode(10);
        test.root.left = new TreeNode(2);
        test.root.left.left = new TreeNode(20);
        test.root.left.right = new TreeNode(1);
        test.root.right = new TreeNode(10);
        test.root.right.right = new TreeNode(-25);
        test.root.right.right.left = new TreeNode(3);
        test.root.right.right.right = new TreeNode(4);
        System.out.println(test.maxPathSum());

    }

    public int maxPathSum() {
        maxPathSum(root);
        return max.val;
    }

    private int maxPathSum(TreeNode root) {
        max = new Max();
        max.val = Integer.MIN_VALUE;
        return maxPathSumUtil(root, max);
    }

    private int maxPathSumUtil(TreeNode root, Max max) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSumUtil(root.left, max);
        int right = maxPathSumUtil(root.right, max);

        int max_single = Math.max(left + root.data, right + root.data);

        max.val = Math.max(max_single, left + right + root.data);

        return max_single;
    }

}
