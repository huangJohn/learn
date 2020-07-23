package com.zh.algs.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/23
 */
public class TreeNodeUtil {


    public static void inorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        inorder(treeNode.left);
        System.out.print(treeNode.data + " -> ");
        inorder(treeNode.right);
    }


    public static TreeNode insertByRootByLevelOrder(TreeNode root, int key) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
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

        return root;
    }


}
