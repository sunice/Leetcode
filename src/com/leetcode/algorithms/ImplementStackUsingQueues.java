package com.leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yan on 11/23/15.
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> queueA = new LinkedList<>();
    private Queue<Integer> queueB = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        if (queueA.isEmpty() && queueB.isEmpty())
            queueA.add(x);
        else if (queueA.isEmpty()) {
            queueA.add(x);
            while (!queueB.isEmpty())
                queueA.add(queueB.poll());
        }
        else {
            queueB.add(x);
            while (!queueA.isEmpty())
                queueB.add(queueA.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!queueA.isEmpty())
            queueA.poll();
        else
            queueB.poll();
    }

    // Get the top element.
    public int top() {
        if (!queueA.isEmpty())
            return queueA.peek();
        else
            return queueB.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queueA.isEmpty() && queueB.isEmpty();
    }
}
