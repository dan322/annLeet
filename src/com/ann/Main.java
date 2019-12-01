package com.ann;

//import com.ann.leetCode.medium.LeetCode153FindMin;
import com.ann.leetCode.hard.LeetCode493ReversePairs;
import com.ann.leetCode.medium.*;
import com.ann.leetCode.simple.*;

import java.util.*;
//import com.ann.leetCode.simple.LeetCode860LemonadeChange;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s = ")(";
        LeetCode32LongestValidParenthese model = new LeetCode32LongestValidParenthese();
        System.out.println(model.longestValidParentheses2(s));
      /*  String s = "()(()()";
        int[] nums = { 1};
        LeetCode213Rob2 model = new LeetCode213Rob2();
        System.out.println(model.rob(nums));*/
       /* LeetCode208Trie trie = new LeetCode208Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));*/
      /*
      char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
       String[] words = {"oath", "pea", "eat", "rain"};
       LeetCode212FindWords model = new LeetCode212FindWords();
        List<String> wordList = model.findWords1(board, words);
       for (String str: wordList)
           System.out.println(str);
           */
       /* LeetCode120MinimumTotal model = new LeetCode120MinimumTotal();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(-1);

        triangle.add(new ArrayList<Integer>());
        triangle.get(1).add(2);
        triangle.get(1).add(3);

        triangle.add(new ArrayList<Integer>());
        triangle.get(2).add(1);
        triangle.get(2).add(-1);
        triangle.get(2).add(-3);

        triangle.add(new ArrayList<Integer>());
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);

        System.out.println(model.minimumTotal(triangle));
        */

       /*LeetCode146LRUCache1 model = new LeetCode146LRUCache1(10);
       model.put(10, 13);
       model.put(3, 17);
       model.put(6, 11);
       model.put(10, 5);
       model.put(9, 10);
        System.out.println(model.get(13));
        model.put(2, 19);
        System.out.println(model.get(2));
        System.out.println(model.get(3));
        model.put(5, 25);
        System.out.println(model.get(8));
        model.put(9, 22);
        model.put(5, 5);
        model.put(1, 30);
        System.out.println(model.get(11));
        model.put(9, 12);
        System.out.println(model.get(7));
        System.out.println(model.get(5));
        System.out.println(model.get(8));
        System.out.println(model.get(9));
        model.put(4, 30);
        model.put(9, 3);
        System.out.println(model.get(9));
        System.out.println(model.get(10));
        System.out.println(model.get(10));
        model.put(6, 14);
        model.put(3, 1);
        System.out.println(model.get(3));
        model.put(10, 11);
        System.out.println(model.get(8));
        model.put(2, 14);
        System.out.println(model.get(1));
        System.out.println(model.get(5));
        System.out.println(model.get(4));
        model.put(11, 4);
        model.put(12, 24);
        model.put(5, 18);
        System.out.println(model.get(13));
        model.put(7, 23);
        System.out.println(model.get(8));
        System.out.println(model.get(12));
        model.put(3, 27);
        model.put(2, 12);
        System.out.println(model.get(5));
        model.put(2, 9);
        model.put(13, 4);
        model.put(8, 18);
        model.put(1, 7);
        System.out.println(model.get(6));
//       model.put(1, 1);
//       model.put(2, 3);
//       model.put(4, 1);
//        System.out.println(model.get(1));
//        System.out.println(model.get(2));
        model.put(3, 3);
        System.out.println(model.get(1));
        model.put(4, 4);
        System.out.println(model.get(1));
        System.out.println(model.get(2));
        System.out.println(model.get(3));
        System.out.println(model.get(4));*/
     /*  LeetCode1122RelativeSortArray model = new LeetCode1122RelativeSortArray();
       int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
       int[] arr2 = {2,1,4,3,9,6};
       for (int num: model.relativeSortArray1(arr1, arr2))
           System.out.println(num);*/
//       int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

      /*
      int[][] intervals = {{1, 4}, {4, 5}};
       LeetCode56MergeInterval model = new LeetCode56MergeInterval();
       for (int[] nums: model.merge(intervals)) {
           System.out.println(nums[0]);
           System.out.println(nums[1]);
           System.out.println(" ");
       }
       */
//        LeetCode493ReversePairs model = new LeetCode493ReversePairs();
//        int[] nums = {1, 3, 2, 3, 1};
//        System.out.println(model.reversePairs(nums));
    }
}
