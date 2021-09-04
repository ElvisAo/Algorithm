package Labuladong及巧妙算法.Reverselist.reverselistNM;

import common.ListNode;

public class ReverseListNM {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode h = new ReverseListNM().reverseNM(n1, 1, 6);
        while (h != null) {
            System.out.print(h.val + "\t");
            h = h.next;
        }
    }

    private ListNode reverseNM(ListNode head, int n, int m) {
        if (n >= m) return head;
        if (n == 1) return reverseFrontN(head, m);
        head.next = reverseNM(head.next, n - 1, m - 1);
        return head;
    }

    ListNode successor = null;

    private ListNode reverseFrontN(ListNode head, int n) {
        if (n <= 0) return head;
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode h = reverseFrontN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return h;
    }
}
