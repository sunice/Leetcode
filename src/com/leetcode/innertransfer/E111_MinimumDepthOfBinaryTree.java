package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

/**
 * Given a binary tree, find its minimum depth1.
 * The minimum depth1 is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Created by Yan on 9/14/16.
 */
public class E111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        else if (root.left == null)
            return minDepth(root.right) + 1;
        else if (root.right == null)
            return minDepth(root.left) + 1;
        else {
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}
