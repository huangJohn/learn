package com.zh.algs.ds.exercise.binarytree;

import com.zh.algs.ds.binarytree.TreeNode;

import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/21
 */
public class InOrderTraversalWithStack {

    private TreeNode root;

    public static void main(String[] args) {
        InOrderTraversalWithStack test = new InOrderTraversalWithStack();
        test.root = new TreeNode(1);
        test.root.left = new TreeNode(2);
        test.root.right = new TreeNode(3);
        test.root.left.left = new TreeNode(4);
        test.root.left.right = new TreeNode(5);

        test.traversalByStack();
    }

    public void traversalByStack() {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || stack.size() > 0) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();//4 - 2 - 5 - 1 -3
            System.out.print(cur.data + " -> ");
            cur = cur.right;
        }

    }

}
