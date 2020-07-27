package com.zh.algs.ds.binarytree;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/26
 */
public class InorderNthNode {

    private TreeNode root = new TreeNode(1);
    private int count = 0;

    public static void main(String[] args) {

        InorderNthNode inorderNthNode = new InorderNthNode();
        inorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(inorderNthNode.root, 2);
        inorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(inorderNthNode.root, 3);
        inorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(inorderNthNode.root, 4);
        inorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(inorderNthNode.root, 5);
        inorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(inorderNthNode.root, 6);

        TreeNodeUtil.inorder(inorderNthNode.root);

        System.out.println();
        inorderNthNode.findNthInorder(inorderNthNode.root,3);

    }

    public void findNthInorder(TreeNode root, int n) {

        if (root == null) {
            return;
        }

        if (count <= n) {

            findNthInorder(root.left, n);

            count++;
            if (count == n) {
                System.out.print(root.data + "\n");
            }

            findNthInorder(root.right, n);
        }

    }

}
