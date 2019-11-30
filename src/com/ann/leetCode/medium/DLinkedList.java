package com.ann.leetCode.medium;

public class DLinkedList {
    private ListNode head;
    private ListNode tail;

    public void addHead(ListNode listNode) {
        ListNode currentHead = head;
        if (head != null) {
            listNode.next = currentHead;
            currentHead.prev = listNode;
        } else {
            tail = listNode;
        }
        head = listNode;
    }

    public void remove(ListNode listNode) {
        boolean removed = false;
        if (listNode.prev == null) {
            removeHead();
            removed = true;
        }
        if (listNode.next == null) {
            removeTail();
            removed = true;
        }
        if (!removed) {
            listNode.prev.next = listNode.next;
            listNode.next.prev = listNode.prev;
        }
    }

    public ListNode getTail() {
        return tail;
    }

    public void removeTail() {
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
    }

    public void removeHead() {
        head = head.next;
        if (head != null)
            head.prev = null;
    }

    public ListNode getHead() {
        return head;
    }
}

class ListNode {
    public ListNode next;
    public ListNode prev;
    public int value;
    public int key;
}
