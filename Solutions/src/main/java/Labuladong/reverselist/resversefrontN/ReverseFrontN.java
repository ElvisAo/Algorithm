package Labuladong.reverselist.resversefrontN;


import common.ListNode;

public class ReverseFrontN {
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
        ListNode h = new ReverseFrontN().reverseN(n1, 6);
        while (h != null) {
            System.out.print(h.val + "\t");
            h = h.next;
        }
    }

    private ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n <= 0) return head;
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode h = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return h;
    }
}
