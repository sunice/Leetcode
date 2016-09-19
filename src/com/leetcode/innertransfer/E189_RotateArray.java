package com.leetcode.innertransfer;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Do it in-place with O(1) extra space
 *
 * TODO solve the problem in different ways!
 *
 * Created by Yan on 9/12/16.
 */
public class E189_RotateArray {
    public static void rotate(int[] nums, int k) {
        int l = nums.length;
        int index, loop;
        k = k % l;
        if (k == 0) return;
        loop = findGcd(nums.length, k);
        for (int i = 0; i < loop; i++) {
            int temp = nums[i], j = i;
            while (true) {
                index = (j + l - k) % l;
                if (index == i) break;
                nums[j] = nums[index];
                j = index;
            }
            nums[j]= temp;
        }
    }

    public static int findGcd(int a, int b) {
        return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
    }

    public void rotate_reverse(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            rotate(nums, i);
            System.out.println(Arrays.toString(nums));
            rotate(nums, nums.length - i);
        }
    }
}
