package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

/**
 * Created by Yan on 9/14/16.
 */
public class E235_LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;
        else if ((p.val - root.val) * (q.val - root.val) <= 0)
            return root;
        else if (p.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
    }
}
