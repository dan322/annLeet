package com.ann.leetCode.medium;

import java.util.PriorityQueue;

public class LeetCode215FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int[] largestKthArr = new int[k];
        int largestSize = 0;
        for (int num: nums) {
            if (largestSize == 0 || (largestSize < k && largestKthArr[largestSize - 1] >= num))
                largestKthArr[largestSize++] = num;
            else if (largestKthArr[largestSize - 1] < num) {
                int index = searchInsertIndex(num, largestKthArr, largestSize - 1);
                System.arraycopy(largestKthArr, index, largestKthArr, index + 1, k - index - 1);
                largestKthArr[index] = num;
                if (largestSize < k)
                    ++largestSize;
            }
        }
        return largestKthArr[k - 1];
    }

    public int searchInsertIndex(int num, int[] arr, int right) {
        int left = 0;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (num < arr[middle])
                left = middle + 1;
            else if (num > arr[middle])
                right = middle - 1;
            else
                return middle;
        }
        return left;
    }

    // use 优先队列
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for (int num: nums) {
            if (heap.size() == k && heap.peek() > num)
                continue;
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }

    // using quick sort
    public int findKthLargest2(int[] nums, int k) {
        return 0;
    }
}