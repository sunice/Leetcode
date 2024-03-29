package com.leetcode.algorithms;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.

 * Created by Yan on 12/15/15.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = cur < 0 ? nums[i] : cur + nums[i];
            max = cur < max? max : cur;
        }
        return max;
    }

    //TODO divide and conquer
    public int maxSubArrayDC(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        int[] nums = {};
        System.out.println(test.maxSubArray(nums));
    }
}
