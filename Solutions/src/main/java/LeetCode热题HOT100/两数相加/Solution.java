package LeetCode热题HOT100.两数相加;

import common.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2, h = new ListNode(-1), c = h;
        int jinwei = 0, v;
        while (t1 != null && t2 != null) {
            v = t1.val + t2.val + jinwei;
            jinwei = v / 10;
            v %= 10;
            c.next = new ListNode(v);
            c = c.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        while (t1 != null) {
            v = t1.val + jinwei;
            jinwei = v / 10;
            v = v % 10;
            c.next = new ListNode(v);
            c = c.next;
            t1 = t1.next;
        }
        while (t2 != null) {
            v = t2.val + jinwei;
            jinwei = v / 10;
            v = v % 10;
            c.next = new ListNode(v);
            c = c.next;
            t2 = t2.next;
        }
        return h.next;
    }
}
