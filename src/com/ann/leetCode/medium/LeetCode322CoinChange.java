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

    /**
     *  F(S) = F(S - C) + 1   F(S)：S 金额所需的最小硬币数量
     *  S：使用的硬币面值和
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] memoryChange = new int[amount];
        return change(amount, coins, memoryChange);
    }

    public int change(int amount, int[] coins, int[] memoryChange)
    {
        if (amount == 0)
            return 0;
        else if (amount < 0)
            return -1;
        if (memoryChange[amount - 1] != 0)
            return memoryChange[amount - 1];
        int minChange = Integer.MAX_VALUE, num;
        for (int i = coins.length - 1; i >= 0; --i) {
            num = change(amount - coins[i], coins, memoryChange);
            if (num > -1)
                minChange = Math.min(minChange, num + 1);
        }
        memoryChange[amount - 1] = minChange == Integer.MAX_VALUE ? -1: minChange;
        return memoryChange[amount - 1];
    }

    /**
     * F(i) 应等于 minj =F(i -cj) + 1   j: j=0…n−1
     * F(i−cj)+1，cj代表的是每个硬币的面值，所以 F(i)F(i) 是前面能组成的金额的最小值 +1。
     * bottom-up
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] memoryChange = new int[amount + 1];
        Arrays.fill(memoryChange, amount + 1);
        memoryChange[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (i >= coins[j] && memoryChange[i] > memoryChange[i - coins[j]])
                    memoryChange[i] = memoryChange[i - coins[j]] + 1;
            }
        }
        return memoryChange[amount] == amount + 1 ? -1: memoryChange[amount];
    }

    /**
     * improvement of coinchange2
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        int[] memoryChange = new int[amount + 1];
        memoryChange[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            memoryChange[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; ++j) {
                if (i >= coins[j] && memoryChange[i] > memoryChange[i - coins[j]])
                    memoryChange[i] = memoryChange[i - coins[j]] + 1;
            }
        }
        return memoryChange[amount] ==  Integer.MAX_VALUE ? -1: memoryChange[amount];
    }
}
