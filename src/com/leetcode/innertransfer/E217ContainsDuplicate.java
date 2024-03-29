package com.leetcode.innertransfer;

import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
 * appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Created by Yan on 9/13/16.
 */
public class E217ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
