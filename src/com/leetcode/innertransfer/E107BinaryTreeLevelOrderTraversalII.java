package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * Created by Yan on 9/14/16.
 */
public class E107BinaryTreeLevelOrderTraversalII {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head.left != null)
                    queue.add(head.left);
                if (head.right != null)
                    queue.add(head.right);
                row.add(head.val);
            }
            result.add(0, row);
        }
        return result;
    }

    public static List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(result, root, 1);
        return result;
    }

    public static void dfs(List<List<Integer>> result, TreeNode node, int depth) {
        if (node == null) return;
        if (result.size() < depth) {
            List<Integer> row = new ArrayList<>();
            result.add(0, row);
        }
        dfs(result, node.left, depth + 1);
        dfs(result, node.right, depth + 1);
        result.get(result.size() - depth).add(node.val);
    }

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, 4, 8, null, 7, 12, 11};
        //Integer[] array = null;
        TreeNode root = TreeNode.deserialize(array);
        System.out.println(Arrays.toString(levelOrderBottomDFS(root).toArray()));
    }
}
