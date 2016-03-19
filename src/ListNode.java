/**
 * Definition for singly-linked list.
 *
 * Created by Yan on 12/6/15.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}

    // transfer an array to a linked list, and return the head node of the list
    public static ListNode deserialize(int[] nums) {
        if (nums.length == 0)
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
}
