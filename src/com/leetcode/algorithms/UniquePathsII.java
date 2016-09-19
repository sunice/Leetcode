package com.leetcode.algorithms;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Created by Yan on 2/21/16.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++)
            if (obstacleGrid[0][i] == 1)
                break;
            else
                temp[i] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    temp[j] = 0;
                else if (j > 0)
                    temp[j] = temp[j - 1] + temp[j];
            }
        return temp[n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        };
        UniquePathsII test = new UniquePathsII();
        System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
    }
}
