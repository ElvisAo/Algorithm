package nowcoder.链表.链表中环的入口结点;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;   // pHead.next的判断是不可少的
        ListNode slow = pHead, fast = pHead;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) return null;
            if (slow == fast) break;
        }
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
