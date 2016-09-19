package com.leetcode.innertransfer;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Created by Yan on 9/13/16.
 */
public class E066_PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        if (carry == 1) {
            int[] newResult = new int[digits.length + 1];
            newResult[0] = 1;
            return newResult;
        } else
            return result;
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9};
        System.out.println(Arrays.toString(plusOne2(digits)));
    }
}
