package com.leetcode.innertransfer;

/**
 * security system will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police
 *
 * Created by Yan on 9/13/16.
 */
public class E198HouseRobber {
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int a0 = 0;
        int a1 = nums[0];
        int curMax = a1;
        for (int i = 1; i < nums.length; i++) {
            curMax = (a0 + nums[i]) > a1 ? (a0 + nums[i]) : a1;
            a0 = a1;
            a1 = curMax;
        }
        return curMax;
    }

    public static int rob2(int[] num) {
        int last = 0;
        int now = 0;
        int tmp;
        for (int n :num) {
            tmp = now;
            now = Math.max(last + n, now);
            last = tmp;
        }
        return now;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(rob(nums));
    }
}
