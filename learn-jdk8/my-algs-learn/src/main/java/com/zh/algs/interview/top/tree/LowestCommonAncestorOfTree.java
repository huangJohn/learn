package com.zh.algs.interview.top.tree;


import com.google.common.collect.Lists;
import com.zh.algs.ds.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/31
 */
public class LowestCommonAncestorOfTree {

    private ArrayList<Integer> pathX = Lists.newArrayList();
    private ArrayList<Integer> pathY = Lists.newArrayList();

    private TreeNode root;

    public static void main(String[] args) {

        LowestCommonAncestorOfTree test = new LowestCommonAncestorOfTree();

        test.root = new TreeNode(1);
        test.root.left = new TreeNode(2);
        test.root.right = new TreeNode(3);
        test.root.left.left = new TreeNode(4);
        test.root.left.right = new TreeNode(5);
        test.root.right.left = new TreeNode(6);
        test.root.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5): " + test.findLca(4,5));
        System.out.println("LCA(4, 6): " + test.findLca(4,6));
        System.out.println("LCA(3, 4): " + test.findLca(3,4));
        System.out.println("LCA(2, 4): " + test.findLca(2,4));
    }

    public int findLca(int x, int y) {
        pathX.clear();
        pathY.clear();
        return lca(x, y);
    }


    public int lca(int x, int y) {

        if (!findPath(root, x, pathX) || !findPath(root, y, pathY)) {
            System.out.println(pathX.size() > 0 ? "x is in tree path" : "x is not in tree path");
            System.out.println(pathY.size() > 0 ? "y is in tree path" : "y is not in tree path");
            return -1;
        }

        int i = 0;
        for (i = 0; i < pathX.size() && i < pathY.size(); i++) {
            if (!pathX.get(i).equals(pathY.get(i))) {
                break;
            }
        }

        return pathX.get(i - 1);
    }

    public boolean findPath(TreeNode root, int x, List<Integer> list) {

        if (root == null) {
            return false;
        }

        list.add(root.data);
        if (root.data == x) {
            return true;
        }

        if (root.left != null && findPath(root.left, x, list)) {
            return true;
        }

        if (root.right != null && findPath(root.right, x, list)) {
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }

}
