package com.leetcode.innertransfer;

import com.leetcode.utils.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * Created by Yan on 9/16/16.
 */
public class E083RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p1 = head, p2 = head.next;
        while (p2 != null) {
            if (p1.val == p2.val)
                p1.next = p2.next;
            else
                p1 = p2;
            p2 = p2.next;
        }
        return head;
    }
}
