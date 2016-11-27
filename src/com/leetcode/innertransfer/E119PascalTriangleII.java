package com.leetcode.innertransfer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3, Return [1,3,3,1].
 * optimize your algorithm to use only O(k) extra space
 *
 * Created by Yan on 9/13/16.
 */
public class E119PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    temp.add(1);
                else
                    temp.add(result.get(j-1) + result.get(j));
            }
            result = temp;
        }
        return result;
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                int tmp = result.get(j - 1) + result.get(j);
                result.set(j, tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = getRow2(3);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
