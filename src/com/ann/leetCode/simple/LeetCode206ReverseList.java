package com.ann.leetCode.simple;

import java.util.Stack;

public class LeetCode206ReverseList {

    //输入: 1->2->3->4->5->NULL
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        Stack<ListNode> listNodeStack = new Stack<>();
        while (head.next != null) {
            listNodeStack.add(head);
            head = head.next;
        }
        ListNode current = head;
        while (!listNodeStack.isEmpty()) {
            current.next = listNodeStack.pop();
            current = current.next;
        }
        current.next = null;
        return head;
    }

    // 递归 todo ann
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prevNode = reverseList(head.next);
        // attention
        head.next.next = head;
        head.next = null;
        return prevNode;
    }

    // 迭代 时间复杂度O(n)
    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return head;
        ListNode newHead = null,
                 currentNode = head;
        while (currentNode.next != null) {
            ListNode tempNode = currentNode;
            currentNode = currentNode.next;
            tempNode.next = newHead;
            newHead = tempNode;
        }
        return newHead;
    }

    public ListNode getHead() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode (int value) {
            val = value;
        }
    }

    public static void main(String[] args) {
        LeetCode206ReverseList leetCode206ReverseList = new LeetCode206ReverseList();
        ListNode head = leetCode206ReverseList.reverseList1(leetCode206ReverseList.getHead());
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
