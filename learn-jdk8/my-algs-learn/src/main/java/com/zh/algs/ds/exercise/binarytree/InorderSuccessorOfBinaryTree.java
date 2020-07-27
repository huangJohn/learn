package com.zh.algs.ds.exercise.binarytree;

import com.zh.algs.ds.binarytree.TreeNode;
import com.zh.algs.ds.binarytree.TreeNodeUtil;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/27
 */
public class InorderSuccessorOfBinaryTree {

    public TreeNode root = new TreeNode(1);

    public static void main(String[] args) {

        InorderSuccessorOfBinaryTree test = new InorderSuccessorOfBinaryTree();
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 2);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 3);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 4);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 5);
        test.root.right.right = new TreeNode(6);
        TreeNodeUtil.inorder(test.root);

        System.out.println();
        test.inorderSuccessor(test.root, test.root.right);
        test.inorderSuccessor(test.root, test.root.right.right);

        test.inorderSuccessor(test.root, test.root.left.right);
        test.inorderSuccessor(test.root, test.root.left.left);
    }

    public void inorderSuccessor(TreeNode root, TreeNode node) {

        if (node.right != null) {
            TreeNode treeNode = leftMostNode(node.right);
            System.out.print("inorder successor of " + node.data + " is " + treeNode.data + "\n");
            return;
        }

        if (node.right == null) {

            TreeNode rightest = rightMostNode(root);
            if (rightest == node) {
                System.out.print("inorder successor of " + node.data + " is None\n");
            } else {
                inorderSuccessorByRecursive(root, node);
            }


        }
    }

    public TreeNode inorderSuccessorByRecursive(TreeNode root, TreeNode node) {

        if (root == null) {
            return null;
        }

        TreeNode tmp = null;
        if (root == node ||
                (tmp = inorderSuccessorByRecursive(root.left, node)) != null ||
                (tmp = inorderSuccessorByRecursive(root.right, node)) != null) {

            if (tmp != null) {

                if (root.left == tmp) {
                    System.out.print("inorder successor of " + node.data + " is " + root.data + "\n");
                    return null;
                }
            }

            return root;
        }

        return null;
    }


    private TreeNode rightMostNode(TreeNode root) {
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    private TreeNode leftMostNode(TreeNode right) {
        TreeNode current = right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
