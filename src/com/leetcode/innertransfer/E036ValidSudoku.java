package com.leetcode.innertransfer;

/**
 * Created by izhang on 9/28/2016.
 */
public class E036ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] counterRow = new int[9];
            int[] counterColumn = new int[9];
            int[] counterBlock = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && ++counterRow[board[i][j] - '1'] > 1)
                    return false;
                if (board[j][i] != '.' && ++counterColumn[board[j][i] - '1'] > 1)
                    return false;
                if (board[i/3*3 + j/3][i%3*3 + j%3] != '.' && ++counterBlock[board[i/3*3 + j/3][i%3*3 + j%3] - '1'] > 1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] input = {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = input[i].charAt(j);
            }
        }
        System.out.println(isValidSudoku(board));
    }
}
