package leetcode.链表.反转链表II;

import common.ListNode;

public class Solution {
    ListNode succ;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right) return head;
        if (left == 1) return reverseFrontN(head, right);
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverseFrontN(ListNode head, int n) {
        if (n <= 0) return head;
        if (n == 1) {
            succ = head.next;
            return head;
        }
        ListNode last = reverseFrontN(head.next, n - 1);
        head.next.next = head;
        head.next = succ;
        return last;
    }
}
