package com.leetcode.innertransfer;

/**
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 *
 * Created by Yan on 9/12/16.
 */
public class E396_RotateFunction {
    public static int maxRotateFunction(int[] A) {
        int sum = 0, cur = 0, max;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            cur += i * A[i];
        }
        max = cur;
        for (int i = 1; i < A.length; i++) {
            cur = cur + sum - A.length * A[A.length - i];
            max = cur > max ? cur : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};
        System.out.println(maxRotateFunction(A));
    }
}
