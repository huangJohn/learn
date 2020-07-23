package com.zh.algs.ds.binarytree;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/23
 */
public class PopulateInOrderSuccessor {

    private TreeNode root = new TreeNode(1);

    private TreeNode next = null;

    public static void main(String[] args) {
        PopulateInOrderSuccessor test = new PopulateInOrderSuccessor();
        TreeNodeUtil.insertByRootByLevelOrder(test.root, 2);
        TreeNodeUtil.insertByRootByLevelOrder(test.root, 3);
        TreeNodeUtil.insertByRootByLevelOrder(test.root, 4);
        TreeNodeUtil.insertByRootByLevelOrder(test.root, 5);
        TreeNodeUtil.insertByRootByLevelOrder(test.root, 6);
        TreeNodeUtil.insertByRootByLevelOrder(test.root, 7);

        test.inorder(test.root);
        System.out.println();

        TreeNodeUtil.inorder(test.root);
        System.out.println();

        test.populateNext(test.root);

        TreeNode left = test.root.left.left;
        while (left != null) {
            System.out.print(left.data + " -> ");
            left = left.next;
        }

        System.out.print("-1");

    }


    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " -> ");
        inorder(root.right);
    }

    public void populateNext(TreeNode root) {

        if (root == null) {
            return;
        }

        populateNext(root.right);
        root.next = next;//最右边node next是null
        next = root;
        populateNext(root.left);

    }

}
