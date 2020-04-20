package com.ann.leetCode.simple;

public class LeetCode160IntersectionNode {

    // 消除长度差     Len(list1) + len(List2) = len(list2) + len(list(1))
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB: p1.next;
            p2 = p2 == null ? headA: p2.next;
        }
        return p1;
    }
}
