package com.ann.leetCode.hard;

public class LeetCode410SplitArray {

    /**
     * use binary search + greedy
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0, minMaxSum, cnt, cntSum;
        for (int num: nums) {
            right += num;
            if (num > left)
                left = num;
        }
        /**
         * [1,2147483646]
         * 2
         */
        if (m == 1)
            return right;
        else if (m >= nums.length)
            return left;

        while (right > left) {
            minMaxSum = (left + right) >> 1;
            cnt = 1;
            cntSum = 0;
            for (int num: nums) {
                if (cntSum + num > minMaxSum) {
                    cntSum = num;
                    cnt++;
                } else {
                    cntSum += num;
                }
            }
            if (cnt > m)
                 left = minMaxSum + 1;
            else
                right = minMaxSum;
        }
        return right;
    }

    /**
     * use dp f(i)(j) = Max(f(k, j - 1), nums[k + 1] + ... + nums[i])
     * k in [0, i)
     * @param nums
     * @param m
     * @return
     */
    public int splitArray1(int[] nums, int m) {
        int[][] dp = new int[nums.length + 1][m + 1];
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < nums.length; ++i) {
            for (int k = 1; k <= m; ++k) {
                for (int j = 0; j <= i; ++j) {
                    dp[i + 1][k] = Math.min(dp[i + 1][k],
                            Math.max(dp[j][k - 1], sum[i + 1] - sum[j]));
                }
            }
        }
        return dp[nums.length][m];
    }
}