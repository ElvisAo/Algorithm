package leetcode.树和图.树.有序链表转换二叉搜索树;

import common.ListNode;
import common.TreeNode;

/**
 * leetcode 109
 * 快慢指针找中点
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head, fast = head, preSlow = null;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        preSlow.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(next);
        return root;
    }
}
