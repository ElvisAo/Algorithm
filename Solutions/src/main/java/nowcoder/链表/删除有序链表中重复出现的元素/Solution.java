package nowcoder.链表.删除有序链表中重复出现的元素;

import common.ListNode;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;
        ListNode listNode = new Solution().deleteDuplicates(l1);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        if (head == null || head.next == null) return head;
        ListNode t = new ListNode(-1);
        t.next = head;
        ListNode slow = t, fast = t.next;
        while (fast != null && fast.next != null) {
            if (slow.next.val == fast.next.val) {
                while (fast.next != null && slow.next.val == fast.next.val) fast = fast.next;
                slow.next = fast.next;
                fast = fast.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return t.next;
    }
}
