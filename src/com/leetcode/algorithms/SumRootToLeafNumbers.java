package com.leetcode.algorithms;

import com.leetcode.utils.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Created by Yan on 2/21/16.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return core(root, 0);
    }

    public int core(TreeNode root, int val) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return val * 10 + root.val;
        else
            return core(root.left, val * 10 + root.val) + core(root.right, val * 10 + root.val);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, null, null, 6, null};
        TreeNode root = TreeNode.deserialize(arr);
        SumRootToLeafNumbers test = new SumRootToLeafNumbers();
        System.out.println(test.sumNumbers(root));
    }
}
