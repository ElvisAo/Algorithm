package nowcoder.判断一个链表是否为回文结构;

import common.ListNode;

import java.util.ArrayList;

public class Solution {
    public boolean isPail(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode t = head, c;
        while (t != null) {
            c = t.next;
            t.next = null;
            list.add(t);
            t = c;
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i).val != list.get(j).val) return false;
        }
        return true;
    }
}
