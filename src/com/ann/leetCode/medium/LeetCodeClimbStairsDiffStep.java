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

    /**
     * 　假设你正在爬楼梯，每次你可以爬 1 个、2 个或 3 个台阶，那么在相邻步数不能相同的条件下，你有多少种不同的方法可以爬到第 n 阶呢？
     *
     *
     *
     * 【解题思路】
     * 　　我们都知道，在不考虑相邻步数不相同的条件下，若要到达第 n 个台阶，方法数 F(n) 有：
     *
     * n = 1时：F(1) = 1
     * n = 2时：F(2) = 2
     * n = 3时：F(3) = 4
     * n > 3时：F(n) = F(n-1) + F(n-2) + F(n-3)
     * 　　而现在加上相邻步数不能相同这个限制条件后，我们该如何考虑呢？
     *
     * 　　首先，我们来思考一下如何才能使相邻步数不相同？由于我们每一次可以爬1个、2个或3个台阶，所以为了使相邻步数不相同，可分如下三种情况来进行讨论：
     *
     * （1）若当前这一步爬了 1 个台阶，那么上一步只能爬 2 个或 3 个台阶；
     * （2）若当前这一步爬了 2 个台阶，那么上一步只能爬 1 个或 3 个台阶；
     * （3）若当前这一步爬了 3 个台阶，那么上一步只能爬 1 个或 2 个台阶。
     * 　　接下来，我们再来分析如何统计在相邻步数不相同的情况下到达第 n 个台阶的方法数？由于我们每一次可以爬1个、2个或3个台阶，所以要想到达第 n 个台阶，我们只能从第n-1个、第n-2个或第n-3个台阶过来，具体情况如下：
     *
     * （1）若是从第 n-1 个台阶爬了 1 个台阶到达了第 n 个台阶，那么此时到达第n个台阶的方法数 = 上一步爬 2 个台阶到达第 n-1 个台阶的方法数 + 上一步爬 3 个台阶到达第 n-1 个台阶的方法数；
     * （2）若是从第 n-2 个台阶爬了 2 个台阶到达了第 n 个台阶，那么此时到达第n个台阶的方法数 = 上一步爬 1 个台阶到达第 n-2 个台阶的方法数 + 上一步爬 3 个台阶到达第 n-2 个台阶的方法数；
     * （3）若是从第 n-3 个台阶爬了 3 个台阶到达了第 n 个台阶，那么此时到达第n个台阶的方法数 = 上一步爬 1 个台阶到达第 n-3 个台阶的方法数 + 上一步爬 2 个台阶到达第 n-3 个台阶的方法数；
     * 　　综上所述，那么到达第 n 个台阶总的方法数就是上述三种不同情况下的方法数之和。
     *
     *
     *
     * 　　通过上述分析，我们可以建立一个二维数组 dp[i][j] ，其中横坐标 i 表示当前这一步爬 i 个台阶（对该题而言，i 的取值只有1、2和3），纵坐标 j 表示第 j 个台阶，而每一个 dp[i][j] 表示的是从上一个位置爬 i 个台阶到达第 j 个台阶时所有满足条件的方法数。
     *
     * 　　首先，我们对这个二维数组进行初始化，如下：
     *      0   0   0   0
     *      0   1   0   1
     *      0   0   1   1
     *      0   0   0   1
     *
     * 　　接着，我们可以通过上面的分析列出如下的递推公式：
     *
     * dp[1][j] = dp[2][j-1]+dp[3][j-1];
     * dp[2][j] = dp[1][j-2]+dp[3][j-2];
     * dp[3][j] = dp[1][j-3]+dp[2][j-3];
     * 　　最后，当递推结束后，dp[1][n] + dp[2][n] + dp[3][n] 就是最终的结果。
     */
    public int climbStairs(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 3;
        int[][] a = new int[4][n + 1];
        a[1][1] = 1;
        a[2][2] = 1;
        a[1][3] = 1;
        a[2][3] = 1;
        a[3][3] = 1;
        for (int i = 4; i <= n; i++) {
            a[1][i] = a[2][i - 1] + a[3][i - 1];
            a[2][i] = a[1][i - 2] + a[3][i - 2];
            a[3][i] = a[1][i - 3] + a[2][i - 3];
        }
        return a[1][n] + a[2][n] + a[3][n];
    }
}
