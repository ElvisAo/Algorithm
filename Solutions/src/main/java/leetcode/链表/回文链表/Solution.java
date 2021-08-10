package leetcode.链表.回文链表;

import common.ListNode;

import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
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
}
