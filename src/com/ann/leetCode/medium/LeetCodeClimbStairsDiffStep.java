package com.ann.leetCode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCodeClimbStairsDiffStep {

    /**
     * 时间复杂度： O(N)
     * 维护的二维数组， 一维表示到n级台阶的前3， 2， 1级台阶的步数情况
     * 2维数组分别表示 到该级台阶的总方案， 最后走1步， 2步， 3步的方案个数
     * 到N级台阶，最后走的步数可能性
     *      1：   f(n-1) - (到达n-1且最后走1步)
     *      2：   f(n-2) - (到达n-2且最后走2步)
     *      3：   f(n-3) - (到达n-3且最后走3步)
     */
    public int climbDiffStep (int n) {
        int[][] prevClimb = {{1, 1, 0, 0}, {1, 0, 1, 0}, {3, 1, 1, 1}};
        if (n < 4)
            return prevClimb[n-1][0];
        int[] climbNew = new int[4];
        for (int i = 4; i <= n; i++) {
            climbNew[1] = prevClimb[2][0] - prevClimb[2][1];
            climbNew[2] = prevClimb[1][0] - prevClimb[1][2];
            climbNew[3] = prevClimb[0][0] - prevClimb[0][3];
            climbNew[0] = climbNew[1] + climbNew[2] + climbNew[3];
            prevClimb[0] = prevClimb[1].clone();
            prevClimb[1] = prevClimb[2].clone();
            prevClimb[2] = climbNew.clone();
        }
        return prevClimb[2][0];
    }
}
