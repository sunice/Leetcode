package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

/**
 * This problem was inspired by this original tweet by Max Howell:
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so fuck off.
 *
 * Created by Yan on 9/14/16.
 */
public class E226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        else {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
            return root;
        }
    }
}
