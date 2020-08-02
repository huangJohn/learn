package com.zh.algs.interview.top.tree;

import com.zh.algs.ds.binarytree.TreeNode;
import com.zh.algs.ds.linkedlist.Node;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/31
 */
public class LowestCommonAncestorOfBst {

    private TreeNode root;

    public static void main(String[] args) {

        LowestCommonAncestorOfBst tree = new LowestCommonAncestorOfBst();
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);

        int n1 = 10, n2 = 14;
        TreeNode t = tree.findLcaOfBst(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.findLcaOfBst(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.findLcaOfBst(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);


    }

    public TreeNode findLcaOfBst(TreeNode root, int x, int y) {

        if (root == null) {
            return null;
        }

        if (root.data > x && root.data > y) {
            return findLcaOfBst(root.left, x, y);
        }

        if (root.data < x && root.data < y) {
            return findLcaOfBst(root.right, x, y);
        }

        return root;
    }

}
