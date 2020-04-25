package com.ann.leetCode.medium;

import java.util.*;

public class LeetCode230KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        int[] smallestK = new int[k];
        for (int i = 0; i < k; ++i)
            smallestK[i] = Integer.MAX_VALUE;
        travelTree(root, smallestK);
        return smallestK[k - 1];
    }

    public void travelTree(TreeNode current, int[] minHeap) {
        if (current.left != null)
            travelTree(current.left, minHeap);
        generateMinHeap(minHeap, current.val);
        if (current.right != null)
            travelTree(current.right, minHeap);
    }

    public void generateMinHeap(int[] smallestK, int val) {
        int left = 0, right = smallestK.length - 1, middle;
        if (val > smallestK[right]) return;
        while (left < right) {
            middle = (right - left) / 2 + left;
            if (smallestK[middle] < val) {
                left = middle + 1;
            } else if (smallestK[middle] > val) {
                right = middle - 1;
            }
        }
        System.arraycopy(smallestK, left, smallestK, left + 1, smallestK.length - left - 1);
        smallestK[left] = val;
    }

    public int kthSmallest1(TreeNode root, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        travelTree1(root, arrayList, k);
        return arrayList.get(k - 1);
    }

    public void travelTree1(TreeNode current, ArrayList<Integer> arrayList, int k) {
        if (current.left != null)
            travelTree1(current.left, arrayList, k);
        arrayList.add(current.val);
        if (--k <= 0)
            return;
        if (current.right != null)
            travelTree1(current.right, arrayList, k);
    }

    //****** 迭代
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }
}