package com.zh.algs.ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/23
 */
public class ReplaceNodeWithSumOfInOrderPredecessorAndSuccessor {

    private TreeNode root = new TreeNode(1);

    public static void main(String[] args) {

        ReplaceNodeWithSumOfInOrderPredecessorAndSuccessor test = new ReplaceNodeWithSumOfInOrderPredecessorAndSuccessor();

        test.root = test.insert(test.root, 2);
        test.root = test.insert(test.root, 3);
        test.root = test.insert(test.root, 4);
        test.root = test.insert(test.root, 5);
        test.inOrder(test.root);

        test.replaceSum(test.root);
        System.out.println();
        test.inOrder(test.root);


    }

    public void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " -> ");
        inOrder(root.right);

    }


    public void replaceSum(TreeNode root) {

        if (root == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        storeInOrderData(root, list);
        list.add(0);

        Index index = new Index();
        index.index = index.index + 1;
        replaceSumUtil(root, list, index);
    }

    public void replaceSumUtil(TreeNode root, List<Integer> list, Index index) {

        if (root == null) {
            return;
        }

        replaceSumUtil(root.left, list, index);

        root.data = list.get(index.index - 1) + list.get(index.index + 1);
        index.index = index.index + 1;

        replaceSumUtil(root.right, list, index);
    }


    public void storeInOrderData(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        storeInOrderData(root.left, list);
        list.add(root.data);
        storeInOrderData(root.right, list);
    }


    public TreeNode insert(TreeNode root, int key) {

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

class Index {
    int index = 0;
}
