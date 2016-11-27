package com.leetcode.innertransfer;

/**
 * Created by Yan on 9/13/16.
 */
public class E121BestTimeBuySellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int minPrice = prices[0];
        int curProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > curProfit)
                curProfit = prices[i] - minPrice;
        }
        return curProfit;
    }

    public static void main(String[] args) {
        int[][] prices = {
                {7, 1, 5, 3, 6, 4},
                {7, 6, 4, 3, 1}
        };
        for (int i = 0; i < prices.length; i++) {
            System.out.println(maxProfit(prices[i]));
        }
    }
}
