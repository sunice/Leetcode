package com.leetcode.MainTry;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are: ["1->2->5", "1->3"]
 *
 * Created by Yan on 12/1/15.
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null)
            return result;
        else if (root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }
        else {
            List<String> left = binaryTreePaths(root.left);
            List<String> right = binaryTreePaths(root.right);
            if (left.size() > 0) {
                for (String str : left)
                    result.add(Integer.toString(root.val) + "->" + str);
            }
            if (right.size() > 0) {
                for (String str : right)
                    result.add(Integer.toString(root.val) + "->" + str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreePaths test = new BinaryTreePaths();
        Integer[] array = {1, 2, 3, null, 5, null, null};
        TreeNode root = TreeNode.deserialize(array);
        System.out.println(test.binaryTreePaths(root));
    }
}
