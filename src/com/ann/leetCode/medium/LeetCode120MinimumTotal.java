package com.ann.leetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode120MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int minTotal = Integer.MAX_VALUE, num;
        boolean compareMin;
        ArrayList<Integer> minLayer = new ArrayList<>();
        for (int i = 0; i < triangle.size(); ++i) {
            compareMin = i == triangle.size() - 1;
            for (int j = 0; j < i + 1; ++j) {
                if (i == 0) {
                    num = triangle.get(i).get(j);
                } else if (j == 0 ) {
                    num = minLayer.get(i - 1) + triangle.get(i).get(j);
                } else if (j == i) {
                    num = minLayer.get(i) + triangle.get(i).get(j);
                } else {
                    num = Math.min(minLayer.get(i - 1), minLayer.get(i)) + triangle.get(i).get(j);
                }
                minLayer.add(0, num);
                if (compareMin)
                    minTotal = Math.min(minTotal, num);
            }
        }
        return minTotal;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int[] minLayer = {0};
        int[] prevMinLayer = {};
        int lastIndex = triangle.size() - 1;
        for (int i = lastIndex; i >= 0; --i) {
            minLayer = new int[i + 1];
            for (int j = 0; j <= i; ++j) {
                minLayer[j] = triangle.get(i).get(j);
                if (i != lastIndex) {
                    minLayer[j] += Math.min(prevMinLayer[j], prevMinLayer[j + 1]);
                }
            }
            prevMinLayer = minLayer.clone();
        }
        return minLayer[0];
    }

    /**
     * todo ann use dp
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {

        return 0;
    }
}
