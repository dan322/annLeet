package com.ann.leetCode.medium;

public class LeetCode213Rob2 {
    /**
     * 抢劫第一间房子则意味着不能抢劫最后一间，此时 考虑的序列为： 1, 2, 3, ..., n
     * 抢劫最后一间房子则意味着不能抢劫第一间房子， 此时考虑的抢劫序列为： 0, 1, 2, ..., n-1
     * 对于这两种情况的状态方程(新序列) 同198
     *    DP[N] = MAX(dp[n-1], dp[n - 2] + nums[n])
     *    时间复杂度为O(N)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(robHouse(nums, 0, nums.length - 1),
                robHouse(nums, 1, nums.length));
    }

    public int robHouse(int[] nums, int start, int end) {
        int maxRob = 0, prevN1 = 0, prevN2 = 0;
        for (; start < end; ++start) {
            maxRob = Math.max(prevN1, prevN2 + nums[start]);
            prevN2 = prevN1;
            prevN1 = maxRob;
        }
        return maxRob;
    }
}
