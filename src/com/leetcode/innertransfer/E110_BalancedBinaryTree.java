package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth1 of
 * the two subtrees of every node never differ by more than 1.
 *
 * Created by Yan on 9/15/16.
 */
public class E110_BalancedBinaryTree {

    // my solution
    public static boolean isBalanced1(TreeNode root) {
        if (root == null)
            return true;
        List<Boolean> result = new ArrayList<>();
        result.add(true);
        depth1(root, result);
        return result.get(0);
    }

    public static int depth1(TreeNode root, List<Boolean> result) {
        if (result.get(0) == false)
            return 0;
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int leftDepth = depth1(root.left, result);
        int rightDepth = depth1(root.right, result);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1)
            result.set(0, false);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // DFS bottom up, use -1 to indicate unbalanced subtree
    public static boolean isBalanced2(TreeNode root) {
        int depth = depth2(root);
        return depth != -1;
    }

    public static int depth2(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = depth2(node.left);
        if (leftDepth == -1)
            return -1;
        int rightDepth = depth2(node.right);
        if (rightDepth == -1)
            return -1;
        if (Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }


    // top down
    public static boolean isBalanced3(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(depth3(root.left) - depth3(root.right)) > 1)
            return false;
        return isBalanced3(root.left) && isBalanced3(root.right);
    }

    public static int depth3(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(depth3(node.left), depth3(node.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 3, null, null};
        TreeNode root = TreeNode.deserialize(arr);
        System.out.println(isBalanced1(root));
        System.out.println(isBalanced2(root));
        System.out.println(isBalanced3(root));
    }
}
