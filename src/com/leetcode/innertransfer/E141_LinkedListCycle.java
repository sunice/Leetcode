package com.leetcode.innertransfer;

import com.leetcode.utils.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * Created by Yan on 9/15/16.
 */
public class E141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
