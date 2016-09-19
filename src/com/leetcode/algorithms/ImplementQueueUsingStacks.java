package com.leetcode.algorithms;

import java.util.Stack;

/**
 * Created by Yan on 11/23/15.
 */
public class ImplementQueueUsingStacks {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        stackA.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!stackB.isEmpty())
            while (!stackA.isEmpty()) {
                stackB.push(stackA.peek());
                stackA.pop();
            }
        stackB.pop();
    }

    // Get the front element.
    public int peek() {
        if (stackB.isEmpty())
            while (!stackA.isEmpty()) {
                stackB.push(stackA.peek());
                stackA.pop();
            }
        return stackB.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}
