package com.leetcode.algorithms;

import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 *
 * Example:  For num = 5 you should return [0,1,1,2,1,2].
 * Created by Yan on 4/4/16.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        int boundary = 1;
        count[0] = 0;
        while (boundary <= num) {
            for (int i = boundary; i < boundary * 2 && i <= num; i++)
                count[i] = count[i - boundary] + 1;
            boundary = boundary * 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 16;
        CountingBits test = new CountingBits();
        System.out.println(Arrays.toString(test.countBits(num)));
    }
}
