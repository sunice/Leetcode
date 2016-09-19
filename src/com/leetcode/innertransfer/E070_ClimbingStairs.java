package com.leetcode.innertransfer;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top
 *
 * Created by Yan on 9/13/16.
 */
public class E070_ClimbingStairs {
    public static int climbStairs(int n) {
        int result = 1, a0 = 1, a1 = 1, i = 2;
        while (i++ <= n) {
            result = a0 + a1;
            a0 = a1;
            a1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(climbStairs(i));
        }
    }
}
