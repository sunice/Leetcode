package com.leetcode.innertransfer;

/**
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Created by Yan on 9/11/16.
 */
public class E334_ReverseString {
    public static String reverseString(String s) {
        if (s == null)
            return null;
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "Hello, World";
        String s2 = null;
        String s3 = "";
        System.out.println(reverseString(s1));
        System.out.println(reverseString(s2));
        System.out.println(reverseString(s3));
    }
}
