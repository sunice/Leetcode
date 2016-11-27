package com.leetcode.innertransfer;

import com.leetcode.utils.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Created by Yan on 9/16/16.
 */
public class E021MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode small = l1.val < l2.val ? l1 : l2;
        ListNode large = l1.val > l2.val ? l1 : l2;
        ListNode head = small;
        while (small != null && large != null) {
            if (small.next == null) {
                small.next = large;
                break;
            }
            else if (small.next.val < large.val)
                small = small.next;
            else {
                ListNode temp = small.next;
                small.next = large;
                small = large;
                large = temp;
            }
        }
        return head;
    }

    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6};
        ListNode l1 = ListNode.deserialize(nums1);
        ListNode l2 = ListNode.deserialize(nums2);
        //ListNode result = mergeTwoListsRecursive(l1, l2);
        ListNode result = mergeTwoLists(l1, l2);
        ListNode.print(result);
    }
}
