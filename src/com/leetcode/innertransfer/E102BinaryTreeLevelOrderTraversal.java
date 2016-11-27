package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;
import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * Created by Yan on 9/14/16.
 */
public class E102BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode head = queue.poll();
                if (head.left != null)
                    queue.add(head.left);
                if (head.right != null)
                    queue.add(head.right);
                row.add(head.val);
            }
            result.add(row);
        }
        return result;
    }

    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traversal(result, root, 1);
        return result;
    }

    public static void traversal(List<List<Integer>> result, TreeNode node, int depth) {
        if (node == null) return;
        if (result.size() < depth) {
            List<Integer> row = new ArrayList<>();
            row.add(node.val);
            result.add(row);
        } else
            result.get(depth - 1).add(node.val);
        traversal(result, node.left, depth + 1);
        traversal(result, node.right, depth + 1);
    }

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, 4, 8, null, 7, 12, 11};
        //Integer[] array = null;
        TreeNode root = TreeNode.deserialize(array);
        System.out.println(Arrays.toString(levelOrder(root).toArray()));
        System.out.println(Arrays.toString(levelOrderDFS(root).toArray()));
    }
}
