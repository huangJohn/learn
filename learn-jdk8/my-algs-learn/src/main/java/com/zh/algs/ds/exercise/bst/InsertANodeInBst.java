package com.zh.algs.ds.exercise.bst;

import com.zh.algs.ds.binarytree.TreeNode;
import com.zh.algs.ds.binarytree.TreeNodeUtil;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/27
 */
public class InsertANodeInBst {

    private TreeNode root = null;

    public static void main(String[] args) {

        InsertANodeInBst test = new InsertANodeInBst();
        test.root = test.insert(test.root, 10);
        TreeNodeUtil.inorder(test.root);

        test.root = test.insert(test.root, 8);
        TreeNodeUtil.inorder(test.root);

        test.root = test.insert(test.root, 14);
        TreeNodeUtil.inorder(test.root);

        test.root = test.insert(test.root, 6);
        TreeNodeUtil.inorder(test.root);

        test.root = test.insert(test.root, 15);
        TreeNodeUtil.inorder(test.root);
    }


    public TreeNode insert(TreeNode root, int data) {


        if (root == null) {
            return new TreeNode(data);
        } else {

            TreeNode tmp = null;

            if (data < root.data) {
                tmp = insert(root.left, data);
                root.left = tmp;
                tmp.parent = root;
            } else {
                tmp = insert(root.right, data);
                root.right = tmp;
                tmp.parent = root;
            }

            return root;
        }

    }

}
