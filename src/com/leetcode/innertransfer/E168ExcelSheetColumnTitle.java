package com.leetcode.innertransfer;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example: 1 -> A 2 -> B 3 -> C...26 -> Z 27 -> AA 28 -> AB
 * Created by Yan on 9/17/16.
 */
public class E168ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        String result = "";
        while (n != 0) {
            char c = (char) ((n - 1) % 26 + 'A');
            result =  c + result;
            n = (n - 1) / 26;
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(convertToTitle(i));
        }
    }
}
