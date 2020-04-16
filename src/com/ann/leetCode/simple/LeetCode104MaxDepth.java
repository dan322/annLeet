package com.ann.leetCode.simple;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode104MaxDepth {

    // 广度优先
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size(), depth = 0;
        while (size-- > 0) {
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            if (size == 0) {
                size = queue.size();
                ++depth;
            }
        }
        return depth;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    //递归 DFS use stack
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int maxDepth = 0;
        Stack<Pair<Integer, TreeNode>> stack = new Stack<>();
        stack.push(new Pair(1, root));
        if (!stack.isEmpty()) {
            Pair<Integer, TreeNode> currentPair = stack.pop();
            int depth = currentPair.getKey();
            TreeNode node = currentPair.getValue();
            if (node.left != null)
                stack.push(new Pair<>(depth + 1, node.left));
            if (node.right != null)
                stack.push(new Pair<>(depth + 1, node.right));
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }


    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
