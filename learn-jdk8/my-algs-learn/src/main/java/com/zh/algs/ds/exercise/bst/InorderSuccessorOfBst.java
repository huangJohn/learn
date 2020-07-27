package com.zh.algs.ds.exercise.bst;

import com.zh.algs.ds.binarytree.TreeNode;
import com.zh.algs.ds.binarytree.TreeNodeUtil;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/27
 */
public class InorderSuccessorOfBst {

    private TreeNode root;

    public static void main(String[] args) {
        InorderSuccessorOfBst test = new InorderSuccessorOfBst();
        test.root = TreeNodeUtil.insertNodeInBst(test.root, 10);
        test.root =TreeNodeUtil.insertNodeInBst(test.root, 6);
        test.root =TreeNodeUtil.insertNodeInBst(test.root, 15);
        test.root = TreeNodeUtil.insertNodeInBst(test.root, 3);
        test.root = TreeNodeUtil.insertNodeInBst(test.root, 7);
        test.root = TreeNodeUtil.insertNodeInBst(test.root, 19);
        TreeNodeUtil.inorder(test.root);

        System.out.println(test.inorderSuccessor(test.root.left.right).data);
        System.out.println(test.inorderSuccessor(test.root.left.left).data);
        System.out.println(test.inorderSuccessor(test.root.left).data);

    }

    public TreeNode inorderSuccessor(TreeNode node) {

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
