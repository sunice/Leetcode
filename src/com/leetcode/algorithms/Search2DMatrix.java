package com.leetcode.algorithms;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Created by Yan on 1/7/16.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int low = 0, high = matrix.length - 1;
        int midRow = 0, midColumn = 0;
        while (low <= high) {
            midRow = (low + high) / 2;
            if (matrix[midRow][0] == target)
                return true;
            else if (matrix[midRow][0] > target)
                high = midRow - 1;
            else if (midRow + 1 > matrix.length - 1 || matrix[midRow + 1][0] > target)
                break;
            else
                low = midRow + 1;
        }
        low = 0;
        high = matrix[0].length - 1;
        while (low <= high) {
            midColumn = (low + high) / 2;
            if (matrix[midRow][midColumn] == target)
                return true;
            else if (matrix[midRow][midColumn] < target)
                low = midColumn + 1;
            else
                high = midColumn - 1;
        }
        return false;
    }

    //convert the 2D matrix to 1D array
    public boolean searchArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int low = 0, high = matrix.length * matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(test.searchMatrix(matrix, 55));
        System.out.println(test.searchArray(matrix, 15));
    }
}
