package com.leetcode.innertransfer;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples: s = "leetcode" return 0 ; s = "loveleetcode", return 2.
 *
 * Created by izhang on 9/24/2016.
 */
public class E387FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray())
            counter[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
