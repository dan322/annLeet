package com.ann;

//import com.ann.leetCode.medium.LeetCode153FindMin;
import com.ann.leetCode.medium.LeetCode32LongestValidParenthese;
import com.ann.leetCode.medium.LeetCode33Search;
import com.ann.leetCode.medium.LeetCodeClimbStairsDiffStep;
import com.ann.leetCode.medium.LeetCode_64_MinPathSum;
import com.ann.leetCode.simple.LeetCode121MaxProfit;
import com.ann.leetCode.simple.LeetCode122MaxProfit2;
//import com.ann.leetCode.simple.LeetCode860LemonadeChange;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,2,3,4,5};
        String s = "()(()()";
        LeetCode122MaxProfit2 model = new LeetCode122MaxProfit2();
        System.out.println(model.maxProfit(nums));
    }
}
