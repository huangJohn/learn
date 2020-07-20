package com.zh.algs.ds.binarytree;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/21
 */
public class TraversalBinaryTree {

    TreeNode root;

    public static void main(String[] args) {

        TraversalBinaryTree test = new TraversalBinaryTree();

        test.root = new TreeNode(1);
        test.root.left = new TreeNode(2);
        test.root.right = new TreeNode(3);
        test.root.left.left = new TreeNode(4);
        test.root.left.right = new TreeNode(5);

        System.out.println("中序");
        test.traversalByInOrder(test.root);
        System.out.println();
        System.out.println("前序");
        test.traversalByPreOrder(test.root);
        System.out.println();
        System.out.println("后序");
        test.traversalByPostOrder(test.root);


    }

    public void traversalByInOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        traversalByInOrder(node.left);
        System.out.print(node.data + " -> ");
        traversalByInOrder(node.right);
    }

    public void traversalByPreOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.print(node.data + " -> ");
        traversalByPreOrder(node.left);
        traversalByPreOrder(node.right);
    }

    public void traversalByPostOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        traversalByPostOrder(node.left);
        traversalByPostOrder(node.right);
        System.out.print(node.data + " -> ");
    }

}
