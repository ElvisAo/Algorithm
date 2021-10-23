package leetcode.链表.删除排序链表中的重复元素;

import common.ListNode;

/**
 * leetcode 83
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = null;
                fast = fast.next;
            } else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head;
    }
}
