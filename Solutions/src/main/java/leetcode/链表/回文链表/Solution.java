package leetcode.链表.回文链表;

import common.ListNode;

import java.util.Stack;

/**
 * leetcode 234
 */
public class Solution {
    public boolean solution_1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null && fast.next == null) slow = slow.next;
        while (!stack.isEmpty()) {
            if (stack.pop().val != slow.val) return false;
            slow = slow.next;
        }
        return true;
    }

    /***
     * 快慢指针找中点，然后反转链表前半部分，再依次比较
     * @param head
     * @return
     */
    public boolean solution_2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h = reverse(head, slow);
        if (fast != null) slow = slow.next;
        while (h != null) {
            if (h.val != slow.val) {
                return false;
            }
            h = h.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head, ListNode slow) {
        ListNode pre = null, cur = head, next;
        while (cur != slow) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
