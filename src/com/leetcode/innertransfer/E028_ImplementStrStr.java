package com.leetcode.innertransfer;

/**
 * implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Created by Yan on 9/15/16.
 */
public class E028_ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length())
            return -1;
        int i, j;
        for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
            if (j == needle.length())
                break;
        }
        return i == haystack.length() - needle.length() + 1 ? -1 : i;
    }

    public static void main(String[] args) {
        String haystack = "abcdefg";
        String needle = "acd";
        System.out.println(strStr(haystack, needle));
    }
}
