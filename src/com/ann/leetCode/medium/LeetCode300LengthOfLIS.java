package com.ann.leetCode.medium;

import java.util.Arrays;

public class LeetCode300LengthOfLIS {
    int[] increaseNum;

    /**
     * [10,9,2,5,3,7,101,18]
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        increaseNum = new int[nums.length];
        int maxLength = 0;
        for (int num: nums) {
            maxLength = Math.max(maxLength, getNumPosition(num, maxLength));
        }
        return maxLength;
    }

    public int getNumPosition(int num, int len)
    {
        if (len == 0) {
            increaseNum[len] = num;
            return len + 1;
        }
        int left = 0, right = len - 1, middle;
        while (left < right) {
            middle = left +  ((right - left) >> 1);
            if (increaseNum[middle] < num) {
                left = middle + 1;
            } else if (increaseNum[middle] == num) {
                return middle + 1;
            } else {
                right = middle - 1;
            }
        }
        int index = increaseNum[left] > num ? left: left + 1;
        increaseNum[index] = num;
        return index + 1;
    }
}
