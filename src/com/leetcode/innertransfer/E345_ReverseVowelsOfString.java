package com.leetcode.innertransfer;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Created by Yan on 9/15/16.
 */
public class E345_ReverseVowelsOfString {
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0)
            return s;
        int p1 = 0, p2 = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while (p1 < p2) {
            while (!isVowel(sb.charAt(p1)) && p1 < p2)
                p1++;
            while (!isVowel(sb.charAt(p2)) && p1 < p2)
                p2--;
            char temp = sb.charAt(p1);
            sb.setCharAt(p1, sb.charAt(p2));
            sb.setCharAt(p2, temp);
            p1++;
            p2--;
        }
        return sb.toString();
    }

    public static boolean isVowel(char c) {
        char lower = Character.toLowerCase(c);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "leetcode";

        System.out.println(reverseVowels(s1));
        System.out.println(reverseVowels(s2));
    }
}
