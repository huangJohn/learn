package com.zh.algs.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/27
 */
public class PrintLevelOrderLineByLine {

    private TreeNode root;

    public static void main(String[] args) {

        PrintLevelOrderLineByLine test = new PrintLevelOrderLineByLine();
        test.root = new TreeNode(1);
        test.root.left = new TreeNode(2);
        test.root.right = new TreeNode(3);
        test.root.left.left = new TreeNode(4);
        test.root.left.right = new TreeNode(5);
        test.root.right.right = new TreeNode(6);

        test.lineByline(test.root);
        test.lineByQueue(test.root);
        test.lineByQueue2(test.root);
    }

    public void lineByQueue2(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 0) {

            TreeNode peek = queue.peek();
            queue.remove();
            if (peek == null) {
                if (queue.size() > 0) {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                if (peek.left != null) {
                    queue.add(peek.left);
                }
                if (peek.right != null) {
                    queue.add(peek.right);
                }
                System.out.print(peek.data + " -> ");
            }

        }

        System.out.println();
    }

    public void lineByQueue(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {

            int size = queue.size();

            if (size == 0) {
                break;
            }

            while (size > 0) {

                TreeNode peek = queue.peek();
                queue.remove();
                System.out.print(peek.data + " -> ");

                if (peek.left != null) {
                    queue.add(peek.left);
                }
                if (peek.right != null) {
                    queue.add(peek.right);
                }

                size--;
            }

            System.out.println();
        }

        System.out.println();
    }

    public void lineByline(TreeNode root) {

        int height = height(root);

        int i;
        for (i = 1; i <= height; i++) {
            printLevelOrder(root, i);
            System.out.println();
        }

        System.out.println();

    }

    private void printLevelOrder(TreeNode root, int level) {

        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " -> ");
        } else if (level > 1) {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        if (lheight > rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

}
