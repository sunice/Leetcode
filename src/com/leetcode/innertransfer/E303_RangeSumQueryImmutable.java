package com.leetcode.innertransfer;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Created by Yan on 9/13/16.
 */
public class E303_RangeSumQueryImmutable {

    private int[] sums;
    public E303_RangeSumQueryImmutable(int[] nums) {
        if (nums != null & nums.length != 0) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = nums[i] + sums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return sums[j];
        else
            return sums[j] - sums[i - 1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3};
        E303_RangeSumQueryImmutable test = new E303_RangeSumQueryImmutable(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= i; j--) {
                System.out.println(test.sumRange(i, j));
            }
        }
    }
}
