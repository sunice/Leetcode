package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * Created by Yan on 9/14/16.
 */
public class E100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null & q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }
}
