package com.leetcode.innertransfer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Created by Yan on 9/15/16.
 */
public class E350IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map1.containsKey(nums1[i]))
                map1.put(nums1[i], 1);
            else
                map1.put(nums1[i], map1.get(nums1[i])+1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i])) {
                list.add(nums2[i]);
                map1.put(nums2[i], map1.get(nums2[i]) - 1);
                if (map1.get(nums2[i]) == 0)
                    map1.remove(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2 ,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
