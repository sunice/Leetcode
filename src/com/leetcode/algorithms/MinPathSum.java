package com.leetcode.algorithms;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * Created by Yan on 12/25/15.
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[] temp = new int[grid[0].length];
        temp[0] = grid[0][0];
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            temp[0] = temp[0] + grid[i][0];
            for (int j = 1; j< temp.length; j++) {
                temp[j] = (temp[j - 1] < temp[j] ? temp[j - 1] : temp[j]) + grid[i][j];
            }
        }
        return temp[temp.length - 1];
    }

    public static void main(String[] args) {
        MinPathSum test = new MinPathSum();
        int[][] grid = {{0}, {1}};
        System.out.println(test.minPathSum(grid));
    }
}
