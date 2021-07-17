package nowcoder.链表.链表内指定区间反转;

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
        ListNode listNode = new Solution().reverseBetween(l1, 3, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) return reverseFront(head, n);
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode successor;

    private ListNode reverseFront(ListNode head, int n) {
        if (n <= 0) return head;
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode H = reverseFront(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return H;
    }
}
