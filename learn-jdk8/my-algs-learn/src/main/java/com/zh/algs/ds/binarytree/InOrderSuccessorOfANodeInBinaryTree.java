package com.zh.algs.ds.binarytree;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/26
 */
public class InOrderSuccessorOfANodeInBinaryTree {

    private TreeNode root = new TreeNode(1);

    public static void main(String[] args) {

        InOrderSuccessorOfANodeInBinaryTree test = new InOrderSuccessorOfANodeInBinaryTree();

        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 2);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 3);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 4);
        test.root = TreeNodeUtil.insertByRootByLevelOrder(test.root, 5);
        test.root.right.right = new TreeNode(6);
        TreeNodeUtil.inorder(test.root);

        System.out.println();
        test.inorderSuccessor(test.root, test.root.right);

        test.inorderSuccessor(test.root, test.root.left.right);

    }

    public void inorderSuccessor(TreeNode root, TreeNode node) {

        if (node.right != null) {
            TreeNode treeNode = leftMostNode(node.right);
            System.out.print("Inorder Successor of " + node.data + " is ");
            System.out.print(treeNode.data + "\n");
        }

        if (node.right == null) {

            TreeNode rightMostNode = rightMostNode(root);

            if (rightMostNode == node) {
                System.out.print("Inorder Successor of " + node.data + " is None\n");
            } else {
                findInorderSuccessorRecursive(root, node);
            }

        }
    }

    public TreeNode findInorderSuccessorRecursive(TreeNode root, TreeNode node) {

        if (root == null) {
            return null;
        }

        TreeNode temp = null;
        if (root == node ||
                (temp = findInorderSuccessorRecursive(root.left, node)) != null ||
                (temp = findInorderSuccessorRecursive(root.right, node)) != null) {

            if (temp != null) {
                if (root.left == temp) {
                    System.out.print("Inorder Successor of " + node.data);
                    System.out.print(" is " + root.data + "\n");
                    return null;
                }
            }
            return root;
        }
        return null;
    }


    public TreeNode leftMostNode(TreeNode right) {

        while (right != null && right.left != null) {
            right = right.left;
        }
        return right;
    }

    public TreeNode rightMostNode(TreeNode root) {
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root;
    }

}
