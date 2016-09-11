package com.leetcode.MainTry;

import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 *
 * Created by Yan on 2/22/16.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        sort(nums);
        return null;
    }

    public static void sort(int[] nums) {

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum test = new ThreeSum();

    }
}
