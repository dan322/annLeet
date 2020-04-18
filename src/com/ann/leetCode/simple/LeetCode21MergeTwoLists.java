package com.ann.leetCode.simple;

public class LeetCode21MergeTwoLists {

    /**
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), prev = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else if (l1.val == l2.val){
                prev.next = l1;
                l1 = l1.next;
                prev.next.next = l2;
                l2 = l2.next;
                prev = prev.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null)
            prev.next = l1;
        if (l2 != null)
            prev.next = l2;
        return head.next;
    }

    //递归 todo ann
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        return l1;
    }


        class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            val = value;
        }
    }
}