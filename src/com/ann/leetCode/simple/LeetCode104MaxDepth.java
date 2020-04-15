package com.ann.leetCode.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    // todo ann DFS 迭代
    public int maxDepth1(TreeNode root) {
        return 0;
    }

    //递归 DFS
    public int maxDepth2(TreeNode root) {
        return 0;
    }


    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
