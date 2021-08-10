package leetcode.链表.排序链表;

import common.ListNode;

public class Exercise {

    public ListNode solution_1(ListNode head) {
        if (head == null || head.next == null) return head;
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode end) {
        if (head == end) return head;
        ListNode slow = head, fast = head;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode post = sort(slow.next, end);
        slow.next = null;
        ListNode pre = sort(head, slow);
        return merge(pre, post);
    }

    private ListNode merge(ListNode pre, ListNode post) {
        if (pre == null || post == null) return pre == null ? post : pre;
        ListNode head = pre;
        if (pre.val < post.val) {
            pre.next = merge(pre.next, post);
        } else {
            post.next = merge(pre, post.next);
            head = post;
        }
        return head;
    }
}
