package com.leetcode.innertransfer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 *
 * Created by Yan on 9/12/16.
 */
public class E001TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
