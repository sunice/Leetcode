package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

/**
 * Given a binary tree, find its maximum depth1.
 * The maximum depth1 is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Created by Yan on 9/14/16.
 */
public class E104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }

    public static void main(String[] args) {

    }
}
