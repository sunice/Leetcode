package com.leetcode.innertransfer;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Created by Yan on 9/12/16.
 */
public class E026_RemoveDups {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int p1 = 0, p2 = 1;
        while (p2 < nums.length) {
            if (nums[p1] == nums[p2])
                p2++;
            else
                nums[++p1] = nums[p2++];
        }
        return p1 + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
