package com.leetcode.innertransfer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 3, Return
 * [
 *    [1],
 *   [1,1],
 *  [1,2,1],
 * ]
 *
 * Created by Yan on 9/12/16.
 */
public class E118_PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        List<Integer> preRow = new ArrayList<>();
        preRow.add(1);
        result.add(preRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    curRow.add(1);
                else
                    curRow.add(preRow.get(j-1) + preRow.get(j));
            }
            result.add(curRow);
            preRow = curRow;
        }
        return result;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    cur.add(1);
                else
                    cur.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            result.add(cur);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate2(5);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
