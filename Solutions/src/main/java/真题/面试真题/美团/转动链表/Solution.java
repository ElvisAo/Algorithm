package 真题.面试真题.美团.转动链表;

import common.ListNode;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * k可能非常大，所以需要先遍历链表取模
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int i = 0;
        ListNode slowPre = null, fastPre = null, slow = head, fast = head;
        while (fast != null) {
            i++;
            fast = fast.next;
        }   // 遍历链表求链表的长度
        k = k % i;
        if (k == 0) return head;    // 如果k是链表长度的整数倍
        i = 0;  // 重置i
        fast = head;
        while (i < k && fast != null) {
            i++;
            fast = fast.next;
        }   // 快指针先走k步
        while (fast != null) {
            slowPre = slow;
            fastPre = fast;
            fast = fast.next;
            slow = slow.next;
        }   // 快慢指针找倒数第k个节点
        slowPre.next = null;    // 断链
        fastPre.next = head;    // 重新拼接
        return slow;    // slow即为新链表的头节点
    }
}