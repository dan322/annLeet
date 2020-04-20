package com.ann;

//import com.ann.leetCode.medium.LeetCode153FindMin;

import com.ann.leetCode.hard.*;
import com.ann.leetCode.medium.*;
import com.ann.leetCode.simple.*;
import com.ann.sortTwo.MergeSort;
import com.ann.sortTwo.QuickSort;
//import com.ann.QuickSort;

import java.util.*;
//import com.ann.leetCode.simple.LeetCode860LemonadeChange;

public class Main {

    public static void main(String[] args) {
        // write your code here
       /* String s = ")(";
        LeetCode32LongestValidParenthese model = new LeetCode32LongestValidParenthese();
        System.out.println(model.longestValidParentheses2(s));*/
  /*      MergeSort model = new MergeSort();
        model.setTotal(40);
        int[] arr = model.generateArr();
        //int[] arr = {86474, 42437, 18279, 28637};
        for (int value: arr)
            System.out.println(value);
        System.out.println("hello");
        model.doSort(arr);*/
//        for (int value: arr)
//            System.out.println(value);
      /* LeetCode56MergeInterval model = new LeetCode56MergeInterval();
//       int[][] intervals = {{1, 4}, {0, 4}};
//       int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
       int[][] intervals = {{4, 5}, {2, 4}, {4, 6}, {3, 4}, {0, 0}, {1, 1}, {3, 5}, {2, 2}};
       for (int[] interval: model.merge1(intervals)) {
           System.out.print(interval[0]);
           System.out.print(" ");
           System.out.println(interval[1]);
       }*/

   /*   LeetCode242ValidAnagram model = new LeetCode242ValidAnagram();
//      char[] chars = {'h','e', 'l', 'l', 'o'};
      char[] chars = {'H','a','n','n','a','h'};
      String s = "car",
              t = "rac";
      System.out.println(model.isAnagram(s, t));*/
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
       /* LeetCode152MaxProduct model = new LeetCode152MaxProduct();
        String str = " +23457de798977534532";
        char[][] matrix = {
                {'1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '1', '1', '0', '0', '0'},
        };
        int[] nums = {-2, 0, -1, -4};
        System.out.println(model.maxProduct2(nums));*/
        LeetCode552CheckRecord2 model = new LeetCode552CheckRecord2();
//       int[] nums = {186, 419, 83, 408};
//       int num = 6249;
        int[] nums = {7, 10, 5, 10, 8};
        int num = 3;
        String str = "PPALL";
//        System.out.println(model.checkRecord1(1000));

      /*  LeetCode706MyHashMap leetCode706MyHashMap = new LeetCode706MyHashMap();
        leetCode706MyHashMap.put(1, 1);
        leetCode706MyHashMap.put(2, 2);
        System.out.println(leetCode706MyHashMap.get(1));
        System.out.println(leetCode706MyHashMap.get(3));
        leetCode706MyHashMap.put(2, 1);
        leetCode706MyHashMap.put(8, 10);
        leetCode706MyHashMap.put(2, 2);
        leetCode706MyHashMap.put(3, 3);
        leetCode706MyHashMap.put(4, 4);
        leetCode706MyHashMap.put(5, 5);
        leetCode706MyHashMap.put(6, 6);
        System.out.println(leetCode706MyHashMap.get(2));
        leetCode706MyHashMap.remove(2);
        System.out.println(leetCode706MyHashMap.get(2));*/

        //LeetCode705MyHashSet leetCode705MyHashSet = new LeetCode705MyHashSet();
        //leetCode705MyHashSet.add(1);
        //leetCode705MyHashSet.add(2);
        //System.out.println(leetCode705MyHashSet.contains(1));
        //System.out.println(leetCode705MyHashSet.contains(3));
        //leetCode705MyHashSet.add(2);
        //leetCode705MyHashSet.add(8);
        //System.out.println(leetCode705MyHashSet.contains(2));
        //leetCode705MyHashSet.remove(1);
        //System.out.println(leetCode705MyHashSet.contains(2));

        /*LeetCode622MyCircularQueue2 leetCode622MyCircularQueue = new LeetCode622MyCircularQueue2(3);
        System.out.println(leetCode622MyCircularQueue.isEmpty());
        System.out.println(leetCode622MyCircularQueue.isFull());

        System.out.println(leetCode622MyCircularQueue.enQueue(1));
        System.out.println(leetCode622MyCircularQueue.enQueue(2));
        System.out.println(leetCode622MyCircularQueue.enQueue(3));
        System.out.println(leetCode622MyCircularQueue.enQueue(4));
        System.out.println(leetCode622MyCircularQueue.Rear());
        System.out.println(leetCode622MyCircularQueue.isFull());
        System.out.println(leetCode622MyCircularQueue.deQueue());
        System.out.println(leetCode622MyCircularQueue.enQueue(4));
        System.out.println(leetCode622MyCircularQueue.Rear());
        System.out.println(leetCode622MyCircularQueue.isEmpty());

        LeetCode641MyCircularDeque1 leetCode641MyCircularDeque = new LeetCode641MyCircularDeque1(3);
        System.out.println(leetCode641MyCircularDeque.insertLast(1));
        System.out.println(leetCode641MyCircularDeque.insertLast(2));
        System.out.println(leetCode641MyCircularDeque.insertFront(3));
        System.out.println(leetCode641MyCircularDeque.insertFront(4));
        System.out.println(leetCode641MyCircularDeque.getRear());
        System.out.println(leetCode641MyCircularDeque.isFull());
        System.out.println(leetCode641MyCircularDeque.deleteLast());
        System.out.println(leetCode641MyCircularDeque.insertFront(4));
        System.out.println(leetCode641MyCircularDeque.getFront());*/

        /*
        LeetCode707MyLinkedList leetCode707MyLinkedList = new LeetCode707MyLinkedList();
        leetCode707MyLinkedList.addAtHead(1);
        leetCode707MyLinkedList.addAtTail(3);
        leetCode707MyLinkedList.addAtHead(2);
        leetCode707MyLinkedList.addAtHead(1);
        leetCode707MyLinkedList.addAtIndex(1, 2);
        leetCode707MyLinkedList.deleteAtIndex(2);
        leetCode707MyLinkedList.addAtHead(6);
        leetCode707MyLinkedList.addAtTail(4);
        System.out.println(leetCode707MyLinkedList.get(0));
        leetCode707MyLinkedList.deleteAtIndex(1);
        System.out.println(leetCode707MyLinkedList.get(1));
        */

//        LeetCode292CanWinNim leetCode292CanWinNim = new LeetCode292CanWinNim();
//        System.out.println(leetCode292CanWinNim.canWinNim(5));

        int[] numArr = {1, 1, 2, 3, 3, 2, 2, 2, 2};
        LeetCode169MajorityElement leetCode169MajorityElement = new LeetCode169MajorityElement();
        System.out.println(leetCode169MajorityElement.majorityElement1(numArr));
    }
}
