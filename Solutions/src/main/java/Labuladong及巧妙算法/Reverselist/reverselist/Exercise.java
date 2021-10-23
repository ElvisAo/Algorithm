package Labuladong及巧妙算法.Reverselist.reverselist;

import common.ListNode;

public class Exercise {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
