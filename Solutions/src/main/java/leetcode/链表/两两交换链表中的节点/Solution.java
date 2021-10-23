package leetcode.链表.两两交换链表中的节点;

import common.ListNode;

/**
 * 等价于两个一组反转链表
 * leetcode 24
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        for (int i = 0; i < 2; i++) {
            fast = fast.next;
        }
        ListNode h = reverse(slow, fast);
        slow.next = swapPairs(fast);
        return h;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode cur = start, pre = null, next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
