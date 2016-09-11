package com.leetcode.MainTry;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 * Created by Yan on 11/30/15.
 */
public class RangeSumQuery {
    public int[] sums;

    public RangeSumQuery(int[] nums) {
        if (nums == null) {
            sums = null;
        } else if (nums.length == 0) {
            sums = new int[0];
        } else {
            this.sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (sums == null) {
            return 0;
        }
        if (i >= sums.length || j >= sums.length || i > j) {
            return 0;
        }
        else if (i == 0) {
            return sums[j];
        }
        else {
            return sums[j] - sums[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        //int[] nums = new int[0];
        RangeSumQuery numArray = new RangeSumQuery(nums);
        System.out.println(numArray.sumRange(0, 1));
        System.out.println(numArray.sumRange(2, 4));
        System.out.println(numArray.sumRange(3, 5));
    }

}
