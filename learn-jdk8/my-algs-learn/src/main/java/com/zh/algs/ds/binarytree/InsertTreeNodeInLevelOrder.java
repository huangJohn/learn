package com.zh.algs.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/22
 */
public class InsertTreeNodeInLevelOrder {

    private TreeNode root;

    public static void main(String[] args) {
        InsertTreeNodeInLevelOrder test = new InsertTreeNodeInLevelOrder();
        test.root = new TreeNode(1);
        test.insertByLevelOrder(test.root, 2);
        test.insertByLevelOrder(test.root, 3);
        test.insertByLevelOrder(test.root, 4);

        test.inOder(test.root);

    }

    public void inOder(TreeNode node) {

        if (node == null) {
            return;
        }

        inOder(node.left);

        System.out.print(node.data + " -> ");

        inOder(node.right);
    }

    public void insertByLevelOrder(TreeNode node, int key) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            TreeNode peek = queue.peek();
            queue.remove();

            if (peek.left == null) {
                peek.left = new TreeNode(key);
                break;
            } else {
                queue.add(peek.left);
            }

            if (peek.right == null) {
                peek.right = new TreeNode(key);
                break;
            } else {
                queue.add(peek.right);
            }
        }

    }


}
