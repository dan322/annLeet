package com.ann;

//import com.ann.leetCode.medium.LeetCode153FindMin;
import com.ann.leetCode.medium.LeetCode33Search;
//import com.ann.leetCode.simple.LeetCode860LemonadeChange;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = new int[]{4,5,6,7,0,1,2};
        LeetCode33Search model = new LeetCode33Search();
        System.out.println(model.search(nums, 0));
    }
}
