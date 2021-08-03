package leetcode.链表.合并K个升序链表;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode phantomHead = new ListNode(-1), t = phantomHead;
        int n = lists.length;
        int rema = n;
        while (rema > 0) {
            int minIndex = 0;
            ListNode minNode = null;
            for (int i = 0; i < n; i++) {
                if (lists[i] != null) {
                    if (minNode == null || lists[i].val < minNode.val) {
                        minIndex = i;
                        minNode = lists[i];
                    }
                }
            }
            if (minNode == null) return phantomHead.next;
            lists[minIndex] = minNode.next;
            t.next = minNode;
            t = t.next;
            if (lists[minIndex] == null) rema--;
        }
        return phantomHead.next;
    }
}
