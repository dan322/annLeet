package com.ann.leetCode.simple;

import java.util.Stack;

//一个栈   空间复杂度低  使用差值
public class LeetCode155MinStack2 {
    private Stack<Integer> numStack;
    private int minNum;

    public LeetCode155MinStack2() {
        numStack = new Stack<>();
    }

    public void push(int x) {
        if (numStack.isEmpty()) {
            minNum = x;
            numStack.push(x - minNum);
        } else {
            numStack.push(x - minNum);
            if (x < minNum)
                minNum = x;
        }
    }

    public int getMinNum() {
        return minNum;
    }

    public void pop() {
        int popNum = numStack.pop();
        if (popNum < 0)
            minNum -= popNum;
    }

    public int top() {
        int num = numStack.peek();
        return num < 0 ? minNum: num + minNum;
    }
}
