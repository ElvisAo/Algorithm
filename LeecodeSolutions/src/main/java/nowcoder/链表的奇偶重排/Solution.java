package nowcoder.链表的奇偶重排;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = new Solution().oddEvenList(l1);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode(-1), even = new ListNode(-1), t = head, oc = odd, ec = even, nex;
        while (t != null) {
            if (t != null) {
                nex = t.next;
                oc.next = t;
                oc = oc.next;
                t.next = null;
                t = nex;
            }
            if (t != null) {
                nex = t.next;
                ec.next = t;
                ec = ec.next;
                t.next = null;
                t = nex;
            }
        }
        oc.next = even.next;
        return odd.next;
    }
}
