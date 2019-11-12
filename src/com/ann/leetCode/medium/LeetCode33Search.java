package com.ann.leetCode.medium;

public class LeetCode33Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        if (nums[left] < nums[right]
                && (target > nums[right] || target < nums[left]))
            return -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
}
