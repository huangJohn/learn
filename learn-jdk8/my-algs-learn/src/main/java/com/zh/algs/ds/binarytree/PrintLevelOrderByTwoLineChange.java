package com.zh.algs.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/27
 */
public class PrintLevelOrderByTwoLineChange {

    private TreeNode root;

    public static void main(String[] args) {

        PrintLevelOrderByTwoLineChange test = new PrintLevelOrderByTwoLineChange();
        test.root = new TreeNode(1);
        test.root.left = new TreeNode(2);
        test.root.right = new TreeNode(3);
        test.root.left.left = new TreeNode(4);
        test.root.left.right = new TreeNode(5);
        test.root.right.left = new TreeNode(6);
        test.root.right.right = new TreeNode(7);
        test.root.left.left.left = new TreeNode(8);
        test.root.left.left.right = new TreeNode(9);
        test.root.left.right.left = new TreeNode(3);
        test.root.left.right.right = new TreeNode(1);
        test.root.right.left.left = new TreeNode(4);
        test.root.right.left.right = new TreeNode(2);
        test.root.right.right.left = new TreeNode(7);
        test.root.right.right.right = new TreeNode(2);
        test.root.left.right.left.left = new TreeNode(16);
        test.root.left.right.left.right = new TreeNode(17);
        test.root.right.left.right.left = new TreeNode(18);
        test.root.right.right.left.right = new TreeNode(19);

        test.printByTwoLineChange(test.root);

    }

    public void printByTwoLineChange(TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " -> ");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        int size;
        int change = 0;
        boolean right2Left = false;

        queue.add(root);

        while (!queue.isEmpty()) {

            change++;

            size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode peek = queue.peek();
                queue.remove();

                if (!right2Left) {
                    System.out.print(peek.data + " -> ");
                } else {
                    stack.push(peek);
                }

                if (peek.left != null) {
                    queue.add(peek.left);
                }
                if (peek.right != null) {
                    queue.add(peek.right);
                }
            }

            if (right2Left) {
                while (!stack.empty()) {
                    TreeNode peek = stack.peek();
                    stack.pop();
                    System.out.print(peek.data + " -> ");
                }
            }

            if (change == 2) {
                right2Left = !right2Left;
                change = 0;
            }

            System.out.println();
        }
    }

}
