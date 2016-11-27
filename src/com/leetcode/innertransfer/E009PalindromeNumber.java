package com.leetcode.innertransfer;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Created by Yan on 9/17/16.
 */
public class E009PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num = x, divide = 1;
        while (num > 9) {
            divide *= 10;
            num /= 10;
        }
        while (x / divide == x % 10) {
            x = (x - x / divide * divide) / 10;
            divide /= 100;
            if (divide == 0 || divide == 1)
                return true;
        }
        return false;
    }

    // try to reverse the number
    public static boolean isPalindromeSimple(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int res = 0;
        while(x > res) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (x == res || x == res / 10);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 121, 1331, 1234, 9999};
        for (int num : nums) {
            System.out.println(isPalindrome(num));
            System.out.println(isPalindromeSimple(num));
        }
    }
}
