package nowcoder.链表.两个链表生成相加链表;

import common.ListNode;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        while (head1 != null) {
            stk1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            stk2.push(head2.val);
            head2 = head2.next;
        }
        int jinwei = 0;
        ListNode head = new ListNode(-1);
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            int val = stk1.pop() + stk2.pop() + jinwei;
            ListNode n = new ListNode(val % 10);
            n.next = head.next;
            head.next = n;
            jinwei = val / 10;
        }
        while (!stk1.isEmpty()) {
            int val = stk1.pop() + jinwei;
            ListNode n = new ListNode(val % 10);
            n.next = head.next;
            head.next = n;
            jinwei = val / 10;
        }
        while (!stk2.isEmpty()) {
            int val = stk2.pop() + jinwei;
            ListNode n = new ListNode(val % 10);
            n.next = head.next;
            head.next = n;
            jinwei = val / 10;
        }
        return head.next;
    }
}
