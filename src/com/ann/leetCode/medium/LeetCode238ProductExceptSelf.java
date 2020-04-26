package com.ann.leetCode.medium;

public class LeetCode238ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int i, r;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (i = 1; i < result.length; ++i)
            result[i] = nums[i - 1] * result[i - 1];
        r = nums[--i];
        for (--i; i >= 0; --i) {
            result[i] *= r;
            r *= nums[i];
        }
        return result;
    }
}