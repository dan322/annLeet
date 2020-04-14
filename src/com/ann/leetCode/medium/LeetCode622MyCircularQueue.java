package com.ann.leetCode.medium;

public class LeetCode622MyCircularQueue {
    // 使用数组/或者链表
    private int[] data;
    private int headIndex;
    private int tailIndex;

    public LeetCode622MyCircularQueue(int k) {
        data = new int[k];
        for (int i = 0; i < k; ++i)
            data[i] = -1;
        headIndex = 0;
        tailIndex = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        data[tailIndex] = value;
        tailIndex = getNextIndex(tailIndex);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        data[headIndex] = -1;
        headIndex = getNextIndex(headIndex);
        return true;
    }

    public int Front() {
        return data[headIndex];
    }

    public int Rear() {
        return data[getPrevIndex(tailIndex)];
    }

    public boolean isEmpty() {
        // use
        return headIndex == tailIndex && data[headIndex] == -1;
    }

    public boolean isFull() {
        return headIndex == tailIndex && data[headIndex] != -1;
    }

    private int getNextIndex(int currentIndex) {
        return currentIndex + 1 == data.length ? 0: currentIndex + 1;
    }

    private int getPrevIndex(int index) {
        return index == 0 ? data.length - 1: index - 1;
    }
}
