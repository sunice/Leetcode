package com.leetcode.innertransfer;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Created by Yan on 9/12/16.
 */
public class E027_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == val && nums[p2] != val) {
                nums[p1++] = nums[p2--];
            } else {
                if (nums[p1] != val) p1++;
                if (nums[p2] == val) p2--;
            }
        }
        return p2 + 1;
    }

    public static void main(String[] args) {
        int[] test1 = {3, 2, 2, 3, 2};
        System.out.println(removeElement(test1, 2));
        System.out.println(Arrays.toString(test1));
    }
}
