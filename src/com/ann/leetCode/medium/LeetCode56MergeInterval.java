package com.ann.leetCode.medium;

public class LeetCode56MergeInterval {

    public int[][] merge(int[][] intervals) {
        int[] intervalNum = new int[intervals.length << 1];
        int index = 0;
        for (int[] interval: intervals) {
            if (index == 0) {
                intervalNum[index++] = interval[0];
                intervalNum[index] = interval[1];
            } else if (intervalNum[index] >= interval[0]) {
                intervalNum[index] = interval[1];
            } else {
                intervalNum[++index] = interval[0];
                intervalNum[++index] = interval[1];
            }
        }
        int[][] intervalMerge = new int[(index + 1) >> 1][2];
        for (int i = 0; i <= index; i += 2) {
            intervalMerge[i >> 1] = new int[] {intervalNum[i], intervalNum[i + 1]};
        }
        return intervalMerge;
    }

    /**
     * merge (归并)
     * @param intervals
     * @return
     */
    public int[][] merge1(int[][] intervals) {
        return intervals;
    }
}
