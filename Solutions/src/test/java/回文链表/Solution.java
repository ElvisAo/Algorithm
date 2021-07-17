package 回文链表;

import common.ListNode;

import java.util.ArrayList;


/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {

    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        // write code here
        if (head == null || head.next == null) return true;
        ArrayList<Integer> list = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            list.add(t.val);
            t = t.next;
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i) != list.get(j)) return false;
        }
        return true;
    }
}