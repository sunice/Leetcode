package com.leetcode.innertransfer;

import com.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Created by Yan on 9/15/16.
 */
public class E101_SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.add(root);
        while (!ll.isEmpty()) {
            int size = ll.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = ll.peek();
                if (i < size / 2) {
                    TreeNode tail = ll.get(size-2*i-1);
                    if (head == null && tail == null)
                        continue;
                    else if (head == null || tail == null || head.val != tail.val)
                        return false;
                }
                if (head != null) {
                    ll.add(head.left);
                    ll.add(head.right);
                }
                ll.poll();
            }
        }
        return true;
    }

    public static boolean isSymmetricBFS(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null)
                continue;
            else if (node1 == null || node2 == null)
                return false;
            else if (node1.val != node2.val)
                return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }

    public static boolean isSymmetricRecursive(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;
        else
            return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,2,3,4,4,3};
        TreeNode root1 = TreeNode.deserialize(arr1);
        System.out.println(isSymmetric(root1));
        System.out.println(isSymmetricBFS(root1));
        System.out.println(isSymmetricRecursive(root1));

        Integer[] arr2 = {1,2,2,null,3,null,3};
        TreeNode root2 = TreeNode.deserialize(arr2);
        System.out.println(isSymmetric(root2));
        System.out.println(isSymmetricBFS(root2));
        System.out.println(isSymmetricRecursive(root2));

        Integer[] arr3 = {1,2,null};
        TreeNode root3 = TreeNode.deserialize(arr3);
        System.out.println(isSymmetric(root3));
        System.out.println(isSymmetricBFS(root3));
        System.out.println(isSymmetricRecursive(root3));
    }
}
