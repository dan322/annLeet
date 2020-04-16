package com.ann.leetCode.simple;

public class LeetCode136SingleNumber {

    /**
     * XOR满足交换律和结合律   a ^ a = 0
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int singleKey = 0;
        for (int i = 0; i < nums.length; ++i)
            singleKey ^= nums[i];
        return singleKey;
    }

    // 数学 2(a + b + c) - (a + b + a + b + c) = c
    public int singleNumber1(int[] nums) {

        return 0;
    }

    // hash table
    public int singleNumber2(int[] nums) {
        return 0;
    }
}
