package com.leetcode.innertransfer;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Created by Yan on 9/13/16.
 */
public class E169_MajorityElement {
    public static int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major)
                count++;
            else if (count == 1)
                major = nums[i];
            else
                count--;
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 4, 5, 1, 2, 2, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
