package com.leetcode.MainTry;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i]
 * is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Created by Yan on 12/10/15.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--)
            output[i] = output[i + 1] * nums[i];
        int temp = 1;
        for (int i = 0;i < nums.length - 1; i++) {
            output[i] = temp * output[i + 1];
            temp = temp * nums[i];
        }
        output[nums.length - 1] = temp;
        return output;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
        int[] nums = {2, 3, 4, 5, 6, 7};
        int[] output = test.productExceptSelf(nums);
        for (int i :output)
            System.out.println(i);
    }
}
