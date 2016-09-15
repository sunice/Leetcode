package com.leetcode.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node
 *
 * Created by Yan on 12/1/15.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    /* transfer an array (level traversal) to a tree, and return the root node
     * input example: {1, 2, null, 3, null}
     */
    public static TreeNode deserialize(Integer[] array) {
        if (array == null || array.length == 0)
            return null;
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        nodes.add(root);
        for (int i = 1; i < array.length; i = i + 2) {
            TreeNode leftNode;
            TreeNode rightNode;
            if (array[i] == null)
                leftNode = null;
            else
                leftNode = new TreeNode(array[i]);
            if (array[i + 1] == null)
                rightNode = null;
            else
                rightNode = new TreeNode(array[i + 1]);
            nodes.add(leftNode);
            nodes.add(rightNode);
            nodes.peek().left = leftNode;
            nodes.peek().right = rightNode;
            nodes.poll();
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, null, 3, null};
        TreeNode root = deserialize(arr);
    }
}

