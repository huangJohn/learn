package com.zh.algs.ds.binarytree;

import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/21
 */
public class InOrderTraversalWithoutRecursive {

    private TreeNode root;

    public static void main(String[] args) {
        InOrderTraversalWithoutRecursive test = new InOrderTraversalWithoutRecursive();

        test.root = new TreeNode(1);
        test.root.left = new TreeNode(2);
        test.root.right = new TreeNode(3);
        test.root.left.left = new TreeNode(4);
        test.root.left.right = new TreeNode(5);

        test.inOrderByStack();
    }

    public void inOrderByStack() {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || stack.size() > 0) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " -> ");
            current = current.right;
        }
    }


}
