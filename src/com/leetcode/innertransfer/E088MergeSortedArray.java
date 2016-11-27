package com.leetcode.innertransfer;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * Created by Yan on 9/13/16.
 */
public class E088MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1, p1 = m - 1, p2 = n - 1;
        for( ; i >= 0 && p1 >= 0 && p2 >= 0; i--)
            if (nums1[p1] < nums2[p2])
                nums1[i] = nums2[p2--];
            else
                nums1[i] = nums1[p1--];
        if (p1 < 0)
            for (int j = 0; j <= i; j++)
                nums1[j] = nums2[j];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[50];
        int[] nums2 = new int[10];
        for (int i = 0; i < 10; i++) {
            nums1[i] = i;
            nums2[i] = i;
        }
        merge(nums1, 10, nums2, 10);
        System.out.println(Arrays.toString(nums1));
    }
}
