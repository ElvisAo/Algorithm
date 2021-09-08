package leetcode.链表.合并两个链表;

import common.ListNode;

/**
 * leetcode 1669
 */
public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode phantom = new ListNode(-1);
        phantom.next = list1;
        ListNode slow = phantom, fast = list1;
        b = b - a;
        while (a > 0) {     // 注意：因为a~b都是不要的，计数从0开始，所以a应该找a.pre，b就应该直接到b，所以下面b>=0，而这里是a>0
            slow = slow.next;
            a--;
        }
        fast = slow;
        while (b >= 0) {
            fast = fast.next;
            b--;
        }
        slow.next = list2;
        slow = list2;
        while (slow.next != null) slow = slow.next;
        slow.next = fast.next;
        return phantom.next;
    }
}
