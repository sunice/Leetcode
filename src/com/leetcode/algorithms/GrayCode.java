package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * Created by Yan on 12/22/15.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if (n == 0)
            return result;
        result.add(1);
        int start = 1;
        int step = 2;
        for (int i = 1; i < n; i++) {
            for (int j = start; j >= 0; j--)
                result.add(result.get(j) + step);
            start = (start + 1) * 2 - 1;
            step = step * 2;
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        List<Integer> result = test.grayCode(4);
        for (int i : result)
            System.out.println(i);
    }
}
