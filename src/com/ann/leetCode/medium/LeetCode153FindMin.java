package com.ann.leetCode.medium;

public class LeetCode153FindMin {
    /**
     * #1 二分搜索
     * 时间复杂度为O(logn)
     * 空间复杂度为O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (right - left > 1) {
            if (nums[left] > nums[right]) {
                left = (right - left)/2 + left;
            } else if (nums[left] < nums[right]) {
                right = left;
                left = left/2;
            }
        }
        return nums[left] > nums[right] ? nums[right]: nums[left];
    }

    /**
     * #1 暴力搜索
     * 时间复杂度为O(N)
     * 空间复杂度为O(1)
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        int min = nums[0];
        for (int num: nums) {
            if (num < min)
                min = num;
        }
        return min;
    }

    /**
     * #3 二分搜索
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
