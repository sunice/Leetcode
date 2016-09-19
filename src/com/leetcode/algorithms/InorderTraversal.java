package com.leetcode.algorithms;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Created by Yan on 12/8/15.
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        if (left != null)
            result.addAll(left);
        result.add(root.val);
        if (right != null)
            result.addAll(right);
        return result;
    }

    // TODO non-recursive, use a stack
    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
        }
        return result;
    }

    public static void main(String[] args) {
        InorderTraversal test = new InorderTraversal();
        Integer[] nums = {1, 2, 3, null, 5};
        TreeNode root = TreeNode.deserialize(nums);
        List<Integer> result = test.inorderTraversal(root);
        System.out.println(result);
    }
}
