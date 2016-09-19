package com.leetcode.innertransfer;

import java.util.HashMap;

/**
 * Created by Yan on 9/17/16.
 */
public class E013_RomanToInteger {
    public static int romanToInt(String s) {
        int result = 0;
        char lsb = ' ';
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M':
                    result += 1000;
                    lsb = 'M';
                    break;
                case 'D':
                    result += 500;
                    lsb = 'D';
                    break;
                case 'C':
                    if (lsb == 'M' || lsb == 'D')
                        result -= 100;
                    else {
                        result += 100;
                        lsb = 'C';
                    }
                    break;
                case 'L':
                    result += 50;
                    lsb = 'L';
                    break;
                case 'X':
                    if (lsb == 'L' || lsb == 'C')
                        result -= 10;
                    else {
                        result += 10;
                        lsb = 'X';
                    }
                    break;
                case 'V':
                    result += 5;
                    lsb = 'V';
                    break;
                case 'I':
                    if (lsb == 'V' || lsb == 'X')
                        result -= 1;
                    else {
                        result += 1;
                        lsb = 'I';
                    }
                    break;
            }
        }
        return result;
    }

    public static int romanToIntMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(s.length() - 1));
        int pre = result;
        for (int i = s.length() - 2; i >= 0; i--) {
            int cur = map.get(s.charAt(i));
            if (cur < pre)
                result -= cur;
            else
                result += cur;
            pre = cur;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"I", "II", "III", "IV", "IX", "XL", "XC", "CD", "CM",
                            "MMMCMXCIX"};
        for (String s : strings) {
            System.out.println(romanToInt(s));
            System.out.println(romanToIntMap(s));
        }
    }
}
