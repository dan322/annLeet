package com.ann;

//import com.ann.leetCode.medium.LeetCode153FindMin;
import com.ann.leetCode.medium.LeetCode32LongestValidParenthese;
import com.ann.leetCode.medium.LeetCode33Search;
import com.ann.leetCode.medium.LeetCodeClimbStairsDiffStep;
import com.ann.leetCode.medium.LeetCode_64_MinPathSum;
//import com.ann.leetCode.simple.LeetCode860LemonadeChange;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        String s = "()(()()";
        LeetCode32LongestValidParenthese model = new LeetCode32LongestValidParenthese();
        System.out.println(model.longestValidParentheses1(s));
    }
}
