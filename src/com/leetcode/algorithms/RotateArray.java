package com.leetcode.algorithms;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Created by Yan on 12/2/15.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        if (k > nums.length) k = k % nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++)
            temp[i] = nums[nums.length - k + i];
        for (int i = nums.length - 1; i >= k; i--)
            nums[i] = nums[i - k];
        for (int i = 0; i < k; i++)
            nums[i] = temp[i];
    }

    public void rotateInPlace(int[] nums, int k) {
        if (k == 0) return;
        if (k > nums.length) k = k % nums.length;

    }

    public static void main(String[] args) {
        RotateArray test = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7,8};
        test.rotate(nums, 9);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
