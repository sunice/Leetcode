package com.leetcode.innertransfer;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Created by izhang on 10/12/2016.
 */
public class E020ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
            Stack<Character> stack1 = new Stack<>();
            Stack<Character> stack2 = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                stack1.push(s.charAt(i));
            }
            while (!stack1.isEmpty()) {
                char peek = stack1.peek();
                switch (peek) {
            case ']':
            case ')':
            case '}':
                stack2.push(peek);
                stack1.pop();
                break;
            case '[':
                if (stack2.isEmpty() || stack2.peek() != ']')
                    return false;
                else {
                    stack1.pop();
                    stack2.pop();
                }
                break;
            case '(':
                if (stack2.isEmpty() || stack2.peek() != ')') {
                    return false;
                } else {
                    stack1.pop();
                    stack2.pop();
                }
                break;
            case '{':
                if (stack2.isEmpty() || stack2.peek() != '}') {
                    return false;
                } else {
                    stack1.pop();
                    stack2.pop();
                }
                break;
            default:
                break;
            }
        }
        return true;
    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack1.push(s.charAt(i));
        }
        while (!stack1.isEmpty()) {
            char peek = stack1.peek();

        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputs = {"()", "()[]{}", "(]", "([)]"};
        for (String s : inputs) {
            System.out.println(isValid(s));
        }
    }
}
