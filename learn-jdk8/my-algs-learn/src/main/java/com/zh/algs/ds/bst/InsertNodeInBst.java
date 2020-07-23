package com.zh.algs.ds.bst;

import com.zh.algs.ds.binarytree.TreeNode;
import com.zh.algs.ds.binarytree.TreeNodeUtil;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/23
 */
public class InsertNodeInBst {


    private TreeNode root;

    public static void main(String[] args) {

        InsertNodeInBst insertNodeInBst = new InsertNodeInBst();
        insertNodeInBst.root = insertNodeInBst.insert(insertNodeInBst.root, 10);
        TreeNodeUtil.inorder(insertNodeInBst.root);
        System.out.println();
        insertNodeInBst.root = insertNodeInBst.insert(insertNodeInBst.root, 5);
        TreeNodeUtil.inorder(insertNodeInBst.root);
        System.out.println();
        insertNodeInBst.root = insertNodeInBst.insert(insertNodeInBst.root, 11);
        TreeNodeUtil.inorder(insertNodeInBst.root);
        System.out.println();
        insertNodeInBst.root = insertNodeInBst.insert(insertNodeInBst.root, 7);
        TreeNodeUtil.inorder(insertNodeInBst.root);
        System.out.println();
        insertNodeInBst.root = insertNodeInBst.insert(insertNodeInBst.root, 1);
        TreeNodeUtil.inorder(insertNodeInBst.root);
        System.out.println();
        insertNodeInBst.root = insertNodeInBst.insert(insertNodeInBst.root, 4);
        TreeNodeUtil.inorder(insertNodeInBst.root);
        System.out.println();
        System.out.println(insertNodeInBst.root);

    }


    public TreeNode insert(TreeNode node, int key) {

        if (node == null) {
            //递归出口
            return new TreeNode(key);
        } else {

            TreeNode tmp = null;

            if (key < node.data) {
                tmp = insert(node.left, key);
                node.left = tmp;
                tmp.parent = node;
            } else {
                tmp = insert(node.right, key);
                node.right = tmp;
                tmp.parent = node;
            }
            return node;
        }


    }

}
