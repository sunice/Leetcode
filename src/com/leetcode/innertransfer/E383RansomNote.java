package com.leetcode.innertransfer;

import java.util.HashMap;

/**
 * Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function
 *  that  will  return  true  if  the  ransom  note  can  be  constructed  from  the  magazines;  otherwise,  it  will  return  false.   
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 * Note: You may assume that both strings contain only lowercase letters.
 *
 * Created by izhang on 9/24/2016.
 */
public class E383RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean canContructArray(String ransomNote, String magazine) {
        int[] counter = new int[26];
        for (char c : magazine.toCharArray())
            counter[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (--counter[c - 'a'] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String maganize = "abb";
        System.out.println(canConstruct(ransomNote, maganize));
        System.out.println(canContructArray(ransomNote, maganize));
    }
}
