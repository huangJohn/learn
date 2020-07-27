package com.zh.algs.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/23
 */
public class TreeNodeUtil {

    public static void postorder(TreeNode treeNode) {
        postorderUtil(treeNode);
        System.out.println();
    }

    private static void postorderUtil(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        postorderUtil(treeNode.left);
        postorderUtil(treeNode.right);
        System.out.print(treeNode.data + " -> ");
    }

    public static void inorder(TreeNode treeNode) {
        inorderUtil(treeNode);
        System.out.println();
    }

    private static void inorderUtil(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        inorderUtil(treeNode.left);
        System.out.print(treeNode.data + " -> ");
        inorderUtil(treeNode.right);
    }

    public static TreeNode insertNodeInBst(TreeNode root, int key) {

        if (root == null) {
            return new TreeNode(key);
        } else {
            TreeNode temp = null;
            if (key < root.data) {
                temp = insertNodeInBst(root.left, key);
                root.left = temp;
                temp.parent = root;
            } else {
                temp = insertNodeInBst(root.right, key);
                root.right = temp;
                temp.parent = root;
            }
            return root;
        }
    }

    public static TreeNode insertByRootByLevelOrder(TreeNode root, int key) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            TreeNode peek = queue.peek();
            queue.remove();

            if (peek.left == null) {
                peek.left = new TreeNode(key);
                break;
            } else {
                queue.add(peek.left);
            }

            if (peek.right == null) {
                peek.right = new TreeNode(key);
                break;
            } else {
                queue.add(peek.right);
            }
        }

        return root;
    }


}
