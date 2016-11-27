package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Created by Yan on 9/14/16.
 */
public class E257BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        else if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }
        else {
            List<String> leftPaths = binaryTreePaths(root.left);
            List<String> rightPahts = binaryTreePaths(root.right);
            for (String s : leftPaths)
                result.add(root.val + "->" + s);
            for (String s : rightPahts)
                result.add(root.val + "->" + s);
            return result;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, null, 5, null, null};
        TreeNode root = TreeNode.deserialize(array);
        System.out.println(binaryTreePaths(root));
    }
}
