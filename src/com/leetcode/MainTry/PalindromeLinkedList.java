package com.leetcode.MainTry;

import com.leetcode.Utils.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Created by Yan on 12/6/15.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode tail = reverse(p1);
        p1 = head; p2 = tail;
        boolean result = false;
        while (p1.val == p2.val) {
            if (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            else {
                result = true;
                break;
            }
        }
        reverse(tail);
        return result;
    }

    // reverse the given linded list and return the new head
    public ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        PalindromeLinkedList test = new PalindromeLinkedList();
        int[] nums = {1};
        ListNode head = ListNode.deserialize(nums);
        System.out.println(test.isPalindrome(head));
    }
}
