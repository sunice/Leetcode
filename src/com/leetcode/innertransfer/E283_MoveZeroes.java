package com.leetcode.innertransfer;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Created by Yan on 9/13/16.
 */
public class E283_MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums.length < 2)
            return;
        int p1 = 0, p2 = 1;
        while (p2 < nums.length) {
            if (nums[p1] == 0 && nums[p2] != 0) {
                nums[p1++] = nums[p2];
                nums[p2++] = 0;
            }
            else if (nums[p1] == 0 && nums[p2] == 0)
                p2++;
            else {
                p1++; p2++;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int lastNoneZeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastNoneZeroPos];
                nums[lastNoneZeroPos++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
