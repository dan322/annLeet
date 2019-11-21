package com.ann;

//import com.ann.leetCode.medium.LeetCode153FindMin;
import com.ann.leetCode.medium.*;
import com.ann.leetCode.simple.LeetCode121MaxProfit;
import com.ann.leetCode.simple.LeetCode122MaxProfit2;
//import com.ann.leetCode.simple.LeetCode860LemonadeChange;

public class Main {

    public static void main(String[] args) {
	// write your code here
     /*   int[] nums = { 7, 4, 5, 6, 9, 10, 4, 1, 6, 5, 9};
        String s = "()(()()";
        LeetCode122MaxProfit2 model = new LeetCode122MaxProfit2();
        System.out.println(model.maxProfit2(nums));*/
        LeetCode208Trie trie = new LeetCode208Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
