package com.leetcode.innertransfer;

import java.util.HashSet;

/**
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number
 * by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Created by Yan on 9/17/16.
 */
public class E202HappyNumber {
    public static boolean isHappy(int n) {
        String s = Integer.toString(n);
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while (sum != 1) {
            sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '1' + 1;
                sum += digit * digit;
            }
            if (!set.add(sum))
                return false;
            s = Integer.toString(sum);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 19, 82, 86, 21};
        for (int num : nums)
            System.out.println(isHappy(num));
    }
}
