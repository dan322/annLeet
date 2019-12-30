package com.ann.leetCode.hard;

public class LeetCode123MaxProfit3 {
    /**
     * todo ann
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] maxProfits = new int[prices.length][2];
        int maxProfit;
        for (int i = 1; i < prices.length; ++i) {
            maxProfits[i][0] = maxProfits[i - 1][0] + Math.max(0, prices[i] - prices[i - 1]);

        }
        return 0;
    }
}
