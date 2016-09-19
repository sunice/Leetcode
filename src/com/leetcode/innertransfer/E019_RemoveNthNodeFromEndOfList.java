package com.leetcode.innertransfer;

import com.leetcode.utils.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Note: Given n will always be valid. Try to do this in one pass.
 *
 * Created by Yan on 9/15/16.
 */
public class E019_RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        if (p2 == null)
            return head.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return head;
    }

    // add a dummy node in front of head to avoid corner cases like single node, remove head, etc
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.deserialize(nums);
        int n = 5;
        ListNode result = removeNthFromEnd2(head, n);
        ListNode.print(result);
    }
}
