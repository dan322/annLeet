package com.ann.leetCode.simple;

import java.util.Stack;

//使用一个栈     （在获得下一个最小值的时候将当前最小值放入栈中）
public class LeetCode155MinStack1 {
    private Stack<Integer> numStack;
    private int minNum;

    public LeetCode155MinStack1() {
        numStack = new Stack<>();
    }

    public void push(int x) {
        if (numStack.isEmpty())
            minNum = x;
        else if (x <= minNum)
            numStack.push(minNum);
        numStack.push(x);
    }

    public int getMinNum() {
        return minNum;
    }

    public void pop() {
        if (numStack.pop() == minNum)
            minNum = numStack.pop();
    }

    public int top() {
        return numStack.peek();
    }

}
