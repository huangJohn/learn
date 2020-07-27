package com.zh.algs.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/27
 */
public class PrintLevelOrder {


    private TreeNode root = new TreeNode(1);

    public static void main(String[] args) {
        PrintLevelOrder test = new PrintLevelOrder();
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 2);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 3);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 4);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 5);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 6);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 7);
        test.printLevelOrder(test.root);
        test.printLevelOrderByQueue(test.root);

    }

    public void printLevelOrderByQueue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            TreeNode peek = queue.peek();
            System.out.print(peek.data + " -> ");

            queue.remove();

            if (peek.left != null) {
                queue.add(peek.left);
            }
            if (peek.right != null) {
                queue.add(peek.right);
            }
        }

        System.out.println();
    }

    public void printLevelOrderUtil(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " -> ");
        } else if (level > 1) {
            printLevelOrderUtil(root.left, level - 1);
            printLevelOrderUtil(root.right, level - 1);
        }
    }

    public void printLevelOrder(TreeNode root) {

        int h = height(root);

        int i = 0;
        for (i = 1; i <= h; i++) {
            printLevelOrderUtil(root, i);
        }
        System.out.println();
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight) {
                return lheight + 1;
            } else {
                return rheight + 1;
            }
        }


    }


}
