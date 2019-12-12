package com.ann.leetCode.medium;

public class LeetCode221MaximalSquare {
    /**
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0        =>  4
     * 时间复杂度：O(mn)
     * dp[i][j]: 表示matrix[i][j]的最大正方形边长
     * dp[i][j]: 如果matrix[i][j]为0，则该点的最大边长为0
     *           如果matrix[i][j]为1，则该点的最大边长为min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
     *
     ************      improvement 增加标兵 使得边界和其他点统一处理  ***********
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix.length < 1 ? 0: matrix[0].length, maxSide = 0;
        int[][] matrixSides = new int[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == '1') {
                    if ( i == 0 || j == 0)
                        matrixSides[i][j] = 1;
                    else {
                        matrixSides[i][j] = Math.min(Math.min(matrixSides[i - 1][j - 1], matrixSides[i - 1][j]), matrixSides[i][j - 1]) + 1;
                    }
                    if (matrixSides[i][j] > maxSide)
                        maxSide = matrixSides[i][j];
                }
            }
        }
        return maxSide * maxSide;
    }

    /**
     * #1 improve of up
     * @param matrix
     * @return
     */
    public int maximalSquare1(char[][] matrix) {
        int r = matrix.length;
        int c = matrix.length < 1 ? 0: matrix[0].length, maxSide = 0, i, j;
        int[] sideUpLevel = new int[c], sideCurLevel = new int[c];
        for (i = 0; i < r; ++i) {
            for (j = 0; j < c; ++j) {
                if (matrix[i][j] == '1') {
                    if (j == 0)
                        sideCurLevel[j] = 1;
                    else {
                        sideCurLevel[j] = Math.min(sideCurLevel[j - 1],
                                Math.min(sideUpLevel[j - 1], sideUpLevel[j])) + 1;
                        sideUpLevel[j - 1] = sideCurLevel[j - 1];
                    }
                    if (sideCurLevel[j] > maxSide)
                        maxSide = sideCurLevel[j];
                } else
                    sideCurLevel[j] = 0;
            }
            sideUpLevel[j - 1] = sideCurLevel[j - 1];
        }
        return maxSide * maxSide;
    }

    public int maximalSquare2(char[][] matrix) {
        int r = matrix.length;
        int c = matrix.length < 1 ? 0: matrix[0].length, maxSide = 0, prev = 0;
        int[] sideArr = new int[c + 1];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == '1') {
                    int tmp = sideArr[j + 1];
                    sideArr[j + 1] = Math.min(prev, Math.min(sideArr[j], sideArr[j + 1])) + 1;
                    if (sideArr[j + 1] > maxSide)
                        maxSide = sideArr[j + 1];
                    prev = tmp;
                } else
                    sideArr[j + 1] = 0;
            }
        }
        return maxSide * maxSide;
    }

    /**
     * todo ann 深度优先搜索
     * @param matrix
     * @return
     */
    public int maximalSquare3(char[][] matrix) {
        int r = matrix.length;
        int c = matrix.length < 1 ? 0: matrix[0].length, maxSide = 0, i, j;
        int[] sideUpLevel = new int[c], sideCurLevel = new int[c];
        for (i = 0; i < r; ++i) {
            for (j = 0; j < c; ++j) {

            }
        }
        return maxSide * maxSide;
    }
}
