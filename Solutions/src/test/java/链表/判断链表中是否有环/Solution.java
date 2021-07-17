package 链表.判断链表中是否有环;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) return false;
            if (fast == slow) return true;
        }
        return false;
    }
}
