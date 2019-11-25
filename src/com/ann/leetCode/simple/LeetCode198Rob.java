package com.ann.leetCode.simple;

public class LeetCode198Rob {
    /**
     * #1
     * dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] robNum = new int[nums.length];
        robNum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            robNum[i] = Math.max(robNum[i - 1], i < 2 ? nums[i]: nums[i] + robNum[i - 2]);
        }
        return robNum[nums.length - 1];
    }

    /**
     * #2 improvement of #1
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums.length == 0)
            return 0;
        int robMaxPrev1 = nums[0],
            robMaxPrev2 = 0,
            robMax;
        for (int i = 1; i < nums.length; ++i) {
            robMax = Math.max(robMaxPrev1, robMaxPrev2 + nums[i]);
            robMaxPrev2 = robMaxPrev1;
            robMaxPrev1 = robMax;
        }
        return robMaxPrev1;
    }
}
