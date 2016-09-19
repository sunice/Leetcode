package com.leetcode.innertransfer;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example: A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 *
 * Created by Yan on 9/17/16.
 */
public class E171_ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"A", "B", "Y", "Z", "AA", "ZZ"};
        for (String s : strings)
            System.out.println(titleToNumber(s));
    }
}
