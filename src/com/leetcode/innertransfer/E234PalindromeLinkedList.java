package com.leetcode.innertransfer;

import com.leetcode.utils.ListNode;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up: Could you do it in O(n) time and O(1) space?
 * Created by Yan on 9/15/16.
 */
public class E234PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        int size = stack.size();
        for (int i = 0; i < size / 2; i++) {
            if (stack.pop().val != node.val)
                return false;
            node = node.next;
        }
        return true;
    }

    private static ListNode cur;
    public static boolean isPalindromeRecursive(ListNode head) {
        if (cur == null)
            cur = head;
        if (head == null)
            return true;
        if (!isPalindromeRecursive(head.next))
            return false;
        if (cur.val == head.val) {
            cur = cur.next;
            return true;
        }
        return false;
    }

    public static boolean isPalindromeReverse(ListNode head) {
        // find the mid node
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode cur = slow, pre = null, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        // compare
        while (pre != null && head.val == pre.val) {
            head = head.next;
            pre = pre.next;
        }
        return pre == null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1};
        ListNode head = ListNode.deserialize(nums);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindromeRecursive(head));
        System.out.println(isPalindromeReverse(head));
    }
}
