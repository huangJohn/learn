package com.zh.algs.interview.top.tree;

import com.zh.algs.ds.binarytree.TreeNode;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/30
 */
public class MinDepthOfTree {


    private TreeNode root;

    public static void main(String[] args) {

        MinDepthOfTree test = new MinDepthOfTree();
        test.root = new TreeNode(1);
        test.root.left = new TreeNode(2);
        test.root.left.left = new TreeNode(6);
        test.root.left.left.left = new TreeNode(7);
        test.root.right = new TreeNode(3);
        test.root.right.left = new TreeNode(4);
        test.root.right.left.right = new TreeNode(5);

        System.out.println(test.minDepthOfTree(test.root));


    }


    public int minDepthOfTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepthOfTree(root.right) + 1;
        }

        if (root.right == null) {
            return minDepthOfTree(root.left) + 1;
        }

        return Math.min(minDepthOfTree(root.left), minDepthOfTree(root.right)) + 1;


    }


}
