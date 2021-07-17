package nowcoder.链表.链表中每k个一组反转;

import common.ListNode;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1), t = head;
        for (int i = 0; i < 5; i++) {
            t.next = new ListNode(new Random().nextInt(100));
            t = t.next;
        }
        t = head.next;
        while (t != null) {
            System.out.print(t.val + ",");
            t = t.next;
        }
        System.out.println();
        t = new Solution().reverseKGroup(head.next, 2);
        while (t != null) {
            System.out.print(t.val + ",");
            t = t.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode a = head, b = head;    // 反转[a, b)的元素
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode h = reverse(a, b);  // 反转后，head就是最后一个元素，h是第一个元素
        a.next = reverseKGroup(b, k);    // 递归处理
        return h;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null, cur = head, next;
        while (cur != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
