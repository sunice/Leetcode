package com.leetcode.utils;

/**
 * Definition for singly-linked list
 * Created by Yan on 9/15/16.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    // transfer an array to a list, and return the head node
    public static ListNode deserialize(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode pre = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode cur = new ListNode(nums[i]);
            pre.next = cur;
            pre = cur;
        }
        return head;
    }

    // print the list nodes
    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        ListNode head = ListNode.deserialize(nums);
        ListNode.print(head);
    }
}
