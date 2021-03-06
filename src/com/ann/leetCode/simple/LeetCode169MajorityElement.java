package com.ann.leetCode.simple;

import java.util.HashMap;

public class LeetCode169MajorityElement {

    public int majorityElement(int[] nums) {
        int compareCount = nums.length - 1 >> 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            int count = hashMap.getOrDefault(num, 0);
            if (count >= compareCount)
                return num;
            hashMap.put(num, count + 1);
        }
        return -1;
    }

    public int majorityElement1(int[] nums) {
        int count = 0;
        int majorityEle = 0;
        for (int num : nums) {
            if (count == 0) {
                majorityEle = num;
                count++;
            } else if (num != majorityEle)
                count--;
            else
                count++;
        }
        return majorityEle;
    }
}