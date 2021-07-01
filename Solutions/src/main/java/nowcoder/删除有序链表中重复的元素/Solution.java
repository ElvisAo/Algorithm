/**
 * @author Everett
 * @date 6/29/2021 2:25 PM
 */
package nowcoder.删除有序链表中重复的元素;

import common.ListNode;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) fast = fast.next;
            else {
                slow.next = fast;
                slow = slow.next;
            }
        }
        slow.next = null;
        return head;
    }
}
