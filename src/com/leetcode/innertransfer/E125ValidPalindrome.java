package com.leetcode.innertransfer;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Created by Yan on 9/15/16.
 */
public class E125ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int p1 = 0, p2 = s.length() - 1;
        while (p1 < p2) {
            if (!isAlphaNumeric(s.charAt(p1))) {
                p1++;
                continue;
            }
            if (!isAlphaNumeric(s.charAt(p2))) {
                p2--;
                continue;
            }
            if (s.charAt(p1) != s.charAt(p2))
                return false;
            p1++;
            p2--;
        }
        return true;
    }

    public static boolean isAlphaNumeric(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public static boolean isPalindrome2(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "0P";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3));

        System.out.println(isPalindrome2(s1));
        System.out.println(isPalindrome2(s2));
        System.out.println(isPalindrome2(s3));
    }
}
