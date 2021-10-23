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
        }   // 先把快指针走n步
        if (fast == null) return null;  // 如果链表长度不够
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

    /**
     * @param head
     * @param n
     * @return
     */
    public ListNode solution_2(ListNode head, int n) {
        ListNode slow = head, fast = head;
        int counter = 1;
        while (counter < n && fast != null) {
            fast = fast.next;
            counter++;
        }
        if (fast.next == null) return head.next;
        ListNode slowPre = null;
        while (fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        slowPre.next = slow.next;
        return head;
    }
}
