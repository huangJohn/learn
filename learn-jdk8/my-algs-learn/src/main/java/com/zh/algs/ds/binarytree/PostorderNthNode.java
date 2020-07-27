package com.zh.algs.ds.binarytree;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/26
 */
public class PostorderNthNode {

    private TreeNode root = new TreeNode(1);
    private int count = 0;

    public static void main(String[] args) {

        PostorderNthNode postorderNthNode = new PostorderNthNode();
        postorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(postorderNthNode.root, 2);
        postorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(postorderNthNode.root, 3);
        postorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(postorderNthNode.root, 4);
        postorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(postorderNthNode.root, 5);
        postorderNthNode.root = TreeNodeUtil.insertByRootByLevelOrder(postorderNthNode.root, 6);

        TreeNodeUtil.postorder(postorderNthNode.root);

        System.out.println();
        postorderNthNode.findNthPostorder(postorderNthNode.root, 3);

    }

    public void findNthPostorder(TreeNode root, int n) {

        if (root == null) {
            return;
        }

        if (count <= n) {

            findNthPostorder(root.left, n);
            findNthPostorder(root.right, n);

            count++;
            if (count == n) {
                System.out.print(root.data + "\n");
            }

        }

    }
}
