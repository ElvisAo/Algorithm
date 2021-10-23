package leetcode.链表.回文链表;

import common.ListNode;

import java.util.Stack;

public abstract class Exercise {

    public boolean solution_1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null && stack.pop().val != slow.val) return false;
        fast = slow.next;
        while (!stack.isEmpty()) {
            if (stack.pop().val != fast.val) return false;
            fast = fast.next;
        }
        return true;
    }
}
