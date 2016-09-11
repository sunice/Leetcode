package com.leetcode.MainTry;

/**
 * Created by Yan on 2/14/16.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        int end = nums.length - 1;
        return coreSortArrayToBST(nums, 0, end);
    }

    public TreeNode coreSortArrayToBST(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = coreSortArrayToBST(nums, start, mid - 1);
        root.right = coreSortArrayToBST(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {

    }
}
