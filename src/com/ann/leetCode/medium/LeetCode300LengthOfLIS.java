package com.ann.leetCode.medium;

import java.util.Arrays;

public class LeetCode300LengthOfLIS {
    int[] increaseNum;

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度： O(n)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        increaseNum = new int[nums.length];
        int maxLength = 0;
        for (int num: nums)
            maxLength = Math.max(maxLength, getNumPosition(num, maxLength));
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
            if (increaseNum[middle] < num)
                left = middle + 1;
            else if (increaseNum[middle] == num)
                return middle + 1;
            else
                right = middle - 1;
        }
        int index = increaseNum[left] >= num ? left: left + 1;
        increaseNum[index] = num;
        return index + 1;
    }

    /**
     * use provided function binarySearch
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        increaseNum = new int[nums.length];
        int maxLength = 0, index;
        for (int num: nums) {
            index = Arrays.binarySearch(increaseNum, 0, maxLength, num);
            if (index < 0)
                index = -(index + 1);
            increaseNum[index] = num;
            if (index == maxLength)
                maxLength++;
        }
        return maxLength;
    }

    /**
     * 时间复杂度: O(logn^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        increaseNum = new int[nums.length];
        int maxLength = 0, j;
        for (int i = 0; i < nums.length; ++i) {
            j = 0;
            increaseNum[i] = 1;
            while (j < i) {
                if (nums[i] > nums[j])
                    increaseNum[i] = Math.max(increaseNum[j] + 1, increaseNum[i]);
                j++;
            }
            maxLength = Math.max(maxLength, increaseNum[i]);
        }
        return maxLength;
    }

}
