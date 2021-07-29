package leetcode.链表.链表的中间结点;

import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
//        return solution_1(head);
        return solution_2(head);
    }

    private ListNode solution_1(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    private ListNode solution_2(ListNode head) {
        ListNode n1 = head, n2 = head;
        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        return n1;
    }
}