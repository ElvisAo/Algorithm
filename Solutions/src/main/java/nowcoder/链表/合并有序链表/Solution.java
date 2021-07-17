package nowcoder.链表.合并有序链表;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode t1 = l1, t2 = l2, h = new ListNode(-1), t = h, c;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                c = t1;
                t1 = t1.next;
            } else {
                c = t2;
                t2 = t2.next;
            }
            t.next = c;
            t = t.next;
        }
        if (t1 != null) t.next = t1;
        if (t2 != null) t.next = t2;
        return h.next;
    }
}
