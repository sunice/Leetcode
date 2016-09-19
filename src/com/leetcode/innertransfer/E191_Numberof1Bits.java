package com.leetcode.innertransfer;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * Created by Yan on 9/17/16.
 */
public class E191_Numberof1Bits {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int num : nums)
            System.out.println(hammingWeight(num));
    }
}
