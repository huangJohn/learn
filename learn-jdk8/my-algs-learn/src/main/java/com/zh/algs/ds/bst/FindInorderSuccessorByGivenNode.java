package com.zh.algs.ds.bst;

import com.zh.algs.ds.binarytree.TreeNode;
import com.zh.algs.ds.binarytree.TreeNodeUtil;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/23
 */
public class FindInorderSuccessorByGivenNode {

    private TreeNode root;

    public static void main(String[] args) {
        FindInorderSuccessorByGivenNode test = new FindInorderSuccessorByGivenNode();
        test.root = test.insertBst(test.root, 20);
        test.root = test.insertBst(test.root, 8);
        test.root = test.insertBst(test.root, 22);
        test.root = test.insertBst(test.root, 4);
        test.root = test.insertBst(test.root, 12);
        test.root = test.insertBst(test.root, 10);
        test.root = test.insertBst(test.root, 14);

        TreeNodeUtil.inorder(test.root);

        System.out.println();

        System.out.println(test.root.left.right.right.data + " 中序successor是：" + test.findInorderSuccessorInBst(test.root.left.right.right).data);
        System.out.println(test.root.left.data + " 中序successor是：" +test.findInorderSuccessorInBst(test.root.left).data);

    }

    public TreeNode insertBst(TreeNode node, int key) {

        if (node == null) {
            return new TreeNode(key);
        } else {

            TreeNode tmp = null;
            if (key < node.data) {
                tmp = insertBst(node.left, key);
                node.left = tmp;
                tmp.parent = node;
            } else {
                tmp = insertBst(node.right, key);
                node.right = tmp;
                tmp.parent = node;
            }

            return node;
        }
    }

    public TreeNode findInorderSuccessorInBst(TreeNode node) {

        if (node.right != null) {
            return minValue(node.right);
        }

        TreeNode parent = node.parent;
        while (parent != null && parent.right == node) {
            node = node.parent;
            parent = parent.parent;
        }
        return parent;
    }

    private TreeNode minValue(TreeNode right) {

        TreeNode current = right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }


}
