package com.ann.leetCode.hard;

import java.util.Arrays;

public class LeetCode188MaxProfit4 {

    /**
     * input:  [2,4,1], k = 2
     * output: 2
     * input:  [3,2,6,5,0,3], k = 2
     * output: 7
     * timeout
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2)
            return 0;
        int[][] maxProfits = new int[2][prices.length];
        for (int j = 1; j <= k; ++j) {
            int minPrice = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                minPrice = Math.min(minPrice, prices[i] - maxProfits[0][i - 1]);
                maxProfits[1][i] = Math.max(prices[i] - minPrice, maxProfits[1][i - 1]);
            }
            maxProfits[0] = Arrays.copyOf(maxProfits[1], prices.length);
        }
        return maxProfits[1][prices.length - 1];
    }

    /**
     * timeout if k is huge
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit1(int k, int[] prices) {
        if (k == 0 || prices.length < 2)
            return 0;
        int[][] maxProfits = new int[2][prices.length];
        int minPrice;
        for (int j = 1; j <= k; ++j) {
            minPrice = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                minPrice = Math.min(minPrice, prices[i] - maxProfits[0][i - 1]);
                maxProfits[1][i] = Math.max(prices[i] - minPrice, maxProfits[1][i - 1]);
                maxProfits[0][i - 1] = maxProfits[1][i - 1];
            }
        }
        return maxProfits[1][prices.length - 1];
    }

    public int maxProfit2(int k, int[] prices) {
        if (k == 0 || prices.length < 2)
            return 0;
        if (k >= (prices.length >> 1)) {
            return greedyProfit(prices);
        }
        int[][] maxProfits = new int[2][prices.length];
        int minPrice;
        for (int j = 1; j <= k; ++j) {
            minPrice = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                minPrice = Math.min(minPrice, prices[i] - maxProfits[0][i - 1]);
                maxProfits[1][i] = Math.max(prices[i] - minPrice, maxProfits[1][i - 1]);
                maxProfits[0][i - 1] = maxProfits[1][i - 1];
            }
        }
        return maxProfits[1][prices.length - 1];
    }

    /**
     * if allowed operate time over 0.5 times of the length of price length
     * then k is 0.5 times of the length of price length
     *
     * also is equal to we operate in every time we can make profit
     * @param prices
     * @return
     */
    public int greedyProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}
