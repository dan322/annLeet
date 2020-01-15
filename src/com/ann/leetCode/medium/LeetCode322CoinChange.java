package com.ann.leetCode.medium;

import java.util.Arrays;

public class LeetCode322CoinChange {

    /**
     * greedy
     * 时间复杂度: o(nlogn)  //sort
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int coinNumNeed = 0, num;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >=0; --i) {
            if (coins[i] > amount)
                continue;
            num = amount / coins[i];
            coinNumNeed += num;
            amount -= coins[i] * num;
            if (amount == 0)
                return coinNumNeed;
        }
        return -1;
    }
}
