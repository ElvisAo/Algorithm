package leetcode.链表.奇偶链表;

import common.ListNode;

/**
 * leetcode 328
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode h = new Solution().oddEvenList(l1);
        while (h != null) {
            System.out.println(h.val + " ");
            h = h.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode oddPhantom = new ListNode(-1), evenPhantom = new ListNode(-1), o = oddPhantom, e = evenPhantom;
        ListNode t = head;
        while (t != null) {
            o.next = t;
            o = o.next;
            t = t.next;
            if (t == null) break;
            e.next = t;
            e = e.next;
            t = t.next;
        }
        o.next = evenPhantom.next;
        e.next = null;
        return oddPhantom.next;
    }
}
