package com.leetcode.innertransfer;

import com.leetcode.utils.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * Example Given: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6 Return: 1 -> 2 -> 3 -> 4 -> 5
 *
 * Created by Yan on 9/16/16.
 */
public class E203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        else if (head.val == val)
            return removeElements(head.next, val);
        else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }

    public ListNode removeElementsIterative(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }
}
