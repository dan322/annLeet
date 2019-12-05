package com.ann.leetCode.medium;

import java.util.*;

public class LeetCode56MergeInterval {

    /**
     * bug if intervals [[1, 4], [0, 4]]
     * @param intervals
     * @return
     */
    public int[][] merge0(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;
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
     * todo ann
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;
        int index = 0;
        // sort intervals according to left bound
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] intervalNum = new int[intervals.length << 1];
        for (int[] interval: intervals) {
            if (index == 0) {
                intervalNum[index++] = interval[0];
                intervalNum[index] = interval[1];
            } else if (intervalNum[index] >= interval[0]) {
                intervalNum[index] = Math.max(intervalNum[index], interval[1]);
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
     * todo ann
     * List to array
     * @param intervals
     * @return
     */
    public int[][] merge1(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 0; i < intervals.length - 1; ++i) {
            if (intervals[i + 1][0] <= right) {
                right = Math.max(right, intervals[i + 1][1]);
            } else {
                res.add(new int[] { left, right});
                left = intervals[i + 1][0];
                right = intervals[i + 1][1];
            }
        }
        res.add(new int[] { left, right});
        return res.toArray(new int[0][0]);
    }

    /**
     * #3 todo ann sort bound (left and right)
     * @param intervals
     * @return
     */
    public int[][]merge2(int[][] intervals) {
        return intervals;
    }
}
