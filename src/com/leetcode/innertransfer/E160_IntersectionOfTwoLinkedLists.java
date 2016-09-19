package com.leetcode.innertransfer;

import com.leetcode.utils.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Created by Yan on 9/16/16.
 */
public class E160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lengthA = 0, lengthB = 0;
        ListNode p1 = headA, p2 = headB;
        while (headA != null) {
            lengthA++;
            headA = headA.next;
        }
        while (headB != null) {
            lengthB++;
            headB = headB.next;
        }
        if (lengthA > lengthB)
            for (int i = 0; i < lengthA - lengthB; i++)
                p1 = p1.next;
        else
            for (int i = 0; i < lengthB - lengthA; i++)
                p2 = p2.next;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // Java solution without knowing the difference of length
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
