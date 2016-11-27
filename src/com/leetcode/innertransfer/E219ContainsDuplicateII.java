package com.leetcode.innertransfer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j
 * in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 * Created by Yan on 9/13/16.
 */
public class E219ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;
            else
                map.put(nums[i], i);
        }
        return false;
    }

    // use sliding window to keep the size of hash set smaller than k
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)  set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))  return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 4};
        System.out.println(containsNearbyDuplicate2(nums, 3));
    }
}
