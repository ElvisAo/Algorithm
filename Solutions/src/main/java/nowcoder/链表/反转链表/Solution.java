package nowcoder.链表.反转链表;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return h;
    }
}
