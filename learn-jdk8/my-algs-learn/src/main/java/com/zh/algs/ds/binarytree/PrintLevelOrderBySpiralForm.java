package com.zh.algs.ds.binarytree;

import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/27
 */
public class PrintLevelOrderBySpiralForm {


    private TreeNode root = new TreeNode(1);

    public static void main(String[] args) {
        PrintLevelOrderBySpiralForm test = new PrintLevelOrderBySpiralForm();

        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 2);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 3);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 4);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 5);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 6);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 7);
        test.printLevelOrderBySpiral(test.root);
        test.printLevelOrderSpiralByStack(test.root);

    }

    public void printLevelOrderBySpiral(TreeNode root) {
        int height = getHeight(root);
        int i;
        boolean l2r = false;
        for (i = 1; i <= height; i++) {
            printLevelOrder(root, i, l2r);
            l2r = !l2r;
        }
        System.out.println();
    }

    public void printLevelOrderSpiralByStack(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (stack1.size() > 0 || stack2.size() > 0) {

            while (stack1.size() > 0) {
                TreeNode peek = stack1.peek();
                stack1.pop();
                System.out.print(peek.data + " -> ");

                if (peek.right != null) {
                    stack2.push(peek.right);
                }

                if (peek.left != null) {
                    stack2.push(peek.left);
                }
            }

            while (stack2.size() > 0) {
                TreeNode peek = stack2.peek();
                stack2.pop();
                System.out.print(peek.data + " -> ");

                if (peek.left != null) {
                    stack1.push(peek.left);
                }

                if (peek.right != null) {
                    stack1.push(peek.right);
                }
            }
        }
        System.out.println();
    }



    private void printLevelOrder(TreeNode root, int level, boolean l2r) {
        if (level == 1) {
            System.out.print(root.data + " -> ");
        } else if (level > 1) {
            if (l2r == true) {
                printLevelOrder(root.left, level - 1, l2r);
                printLevelOrder(root.right, level - 1, l2r);
            } else {
                printLevelOrder(root.right, level - 1, l2r);
                printLevelOrder(root.left, level - 1, l2r);
            }
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);

        if (lHeight > rHeight) {
            return lHeight + 1;
        } else {
            return rHeight + 1;
        }
    }

}
