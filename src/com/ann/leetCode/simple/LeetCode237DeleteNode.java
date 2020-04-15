package com.ann.leetCode.simple;

// notice node is not the last node
public class LeetCode237DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            val = val;
        }
    }
}