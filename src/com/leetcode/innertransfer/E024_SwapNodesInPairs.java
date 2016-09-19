package com.leetcode.innertransfer;

import com.leetcode.utils.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * Created by Yan on 9/16/16.
 */
public class E024_SwapNodesInPairs {
    public static ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        head.next = swapPairsRecursive(temp.next);
        temp.next = head;
        return temp;
    }

    public static ListNode swapPairsIterative(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = head.next;
        ListNode pre = head, cur = head;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            pre.next = temp;
            temp.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return result;
    }

    public ListNode swapPairsDummyNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNode.deserialize(nums);
        //ListNode result = swapPairsRecursive(head);
        ListNode result = swapPairsIterative(head);
        ListNode.print(result);
    }
}
