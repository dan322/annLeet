package com.ann.leetCode.medium;

import java.util.Arrays;

public class LeetCode322CoinChange {

    /**
     * greedy  too young too simple  (greedy is not suitable for this case,
     * maybe money not the largest combination is the best)
     * 时间复杂度: o(nlogn)  //sort
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int coinNumNeed = 0, num;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; --i) {
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

    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] memoryChange = new int[amount];
        return change(amount, coins, 0, memoryChange);
    }

    public int change(int amount, int[] coins, int changeNum, int[] memoryChange)
    {
        if (amount == 0)
            return changeNum + 1;
        else if (amount < 0)
            return -1;
        int minChange = Integer.MAX_VALUE, num;
        for (int i = coins.length - 1; i >= 0; --i) {
            int amountCur = amount - coins[i];
            num = memoryChange[amountCur - 1];
            if (num == 0) {
                num = change(amountCur, coins, changeNum + 1, memoryChange);
                memoryChange[amountCur - 1] = num;
            }
            if (num > -1)
                minChange = Math.min(minChange, num);
        }
        return minChange == Integer.MAX_VALUE ? -1: minChange;
    }
}
