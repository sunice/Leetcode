package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 *
 * Created by Yan on 9/14/16.
 */
public class E112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        else if (root.left == null && root.right == null)
            return root.val == sum;
        else
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
