package com.ann.leetCode.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

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
        int doubleSum = 0, sum = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            if (!numSet.contains(num)) {
                doubleSum += num;
                numSet.add(num);
            }
            sum += num;
        }
        return doubleSum * 2 - sum;
    }

    // hash set
    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        for (int num : nums) {
            if (!hashtable.containsKey(num))
                hashtable.put(num, 1);
            else
                hashtable.remove(num);
        }
        for (int num : nums)
            if (hashtable.containsKey(num))
                return num;
        return 0;
    }
}
