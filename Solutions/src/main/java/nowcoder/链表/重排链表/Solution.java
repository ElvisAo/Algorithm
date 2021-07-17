/**
 * @author Everett
 * @date 6/29/2021 11:45 AM
 */
package nowcoder.链表.重排链表;

import common.ListNode;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        new Solution().reorderList(l1);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }

    //要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode t = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (t != null) {
            list.add(t);
            t = t.next;
        }
        int size = list.size();
        ListNode f, s, pre = new ListNode(-1);
        int i = 0, j = size - 1;
        for (; i < j; i++, j--) {
            f = list.get(i);
            s = list.get(j);

            pre.next = f;
            f.next = s;
            pre = s;
            s.next = null;
        }
        if (i == j && size % 2 == 1) {
            pre.next = list.get(i);
            pre = pre.next;
            pre.next = null;
        }
    }
}
