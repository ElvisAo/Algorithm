package nowcoder.链表.划分链表;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(-1);
        l1.next = l2;
        ListNode list = new Solution().partition(l1, 2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode min = new ListNode(-1), mint = min, max = new ListNode(-1), maxt = max, t = head;
        while (t != null) {
            if (t.val < x) {
                mint.next = t;
                mint = mint.next;
                t = t.next;
                mint.next = null;
            } else {
                maxt.next = t;
                maxt = maxt.next;
                t = t.next;
                maxt.next = null;
            }
        }
        mint.next = max.next;
        return min.next;
    }
}
