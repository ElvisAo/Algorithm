package leetcode.链表.删除链表的倒数第N个结点;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 1;
        ListNode slow = head, fast = head, slowPre = null;
        while (fast != null && counter < n) {
            fast = fast.next;
            counter++;
        }
        if (fast == null) return null;
        while (fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slowPre == null) {
            slowPre = slow.next;
            slow.next = null;
            return slowPre;
        } else {
            slowPre.next = slow.next;
            slow.next = null;
            return head;
        }
    }
}
