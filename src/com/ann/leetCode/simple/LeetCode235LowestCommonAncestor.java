package com.ann.leetCode.simple;

public class LeetCode235LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if ((p.val <= root.val && q.val >= root.val)
                || (p.val >= root.val && q.val <= root.val))
            return root;
        return p.val < root.val ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right, p, q);
    }

    //迭代
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val)
                curr = curr.left;
            else if (p.val > curr.val && q.val > curr.val)
                curr = curr.right;
            else
                break;
        }
        return curr;
    }

    //concise
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left: root.right;
        return root;
    }

    //concise
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        return (root.val - p.val) * (root.val - q.val) < 1 ? root :
                lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
    }

        class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
