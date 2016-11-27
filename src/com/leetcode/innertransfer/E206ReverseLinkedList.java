package com.leetcode.innertransfer;

import com.leetcode.utils.ListNode;

/**
 * Reverse a singly linked list. A linked list can be reversed either iteratively or recursively.
 * Created by Yan on 9/16/16.
 */
public class E206ReverseLinkedList {
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        else {
            ListNode result = reverseListRecursive(head.next);
            ListNode temp = head.next;
            head.next = null;
            temp.next = head;
            return result;
        }
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode pre = null, cur = head, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
