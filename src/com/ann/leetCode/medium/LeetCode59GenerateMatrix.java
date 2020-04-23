package com.ann.leetCode.medium;

public class LeetCode59GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1, r = 0, c = 0, endR = n - 1, endC = n - 1, startR = 0, startC = 0;
        while (num <= n * n) {
            for (; c <= endC; ++c)
                matrix[r][c] = num++;
            for (r++; r <= endR; ++r)
                matrix[r][endC] = num++;
            endC--;
            for (c = endC; c >= startC; --c)
                matrix[endR][c] = num++;
            endR--;
            c++;
            for (r = endR; r > startR; --r)
                matrix[r][c] = num++;
            r++;
            c++;
            startR++;
            startC++;
        }
        return matrix;
    }

    /** 使用上下左右边界 **/
    public int[][] generateMatrix1(int n) {
        int[][] matrix = new int[n][n];
        int num = 1, l = 0, r = n - 1, t = 0, b = n - 1;
        while (num <= n * n) {
            for (int i = l; i <= r; ++i)
                matrix[t][i] = num++;
            t++;
            for (int i = t; i <= b; ++i)
                matrix[i][r] = num++;
            r--;
            for (int i = r; i >= l; --i)
                matrix[b][i] = num++;
            b--;
            for (int i = b; i >= t; --i)
                matrix[i][l] = num++;
            l++;
        }
        return matrix;
    }



}