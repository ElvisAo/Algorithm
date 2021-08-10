package leetcode.链表.相交链表;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a_num = 0, b_num = 0;
        ListNode cur_a = headA, cur_b = headB;
        while (cur_a != null) {
            cur_a = cur_a.next;
            a_num++;
        }
        while (cur_b != null) {
            cur_b = cur_b.next;
            b_num++;
        }
        int dis = Math.abs(a_num - b_num);
        if (a_num > b_num) {
            ListNode t = headA;
            headA = headB;
            headB = t;
        }
        while (dis > 0) {
            headB = headB.next;
            dis--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
