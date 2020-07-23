package com.zh.algs.ds.binarytree;

import java.util.StringJoiner;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/21
 */
public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode next;
    public TreeNode parent;

    public TreeNode(int data) {
        this.data = data;
        left = right = next = parent = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                .add("data=" + data)
                .add("left=" + left)
                .add("right=" + right)
                .toString();
    }
}
