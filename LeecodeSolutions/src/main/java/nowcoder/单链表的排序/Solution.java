package nowcoder.单链表的排序;

import common.ListNode;

import java.util.ArrayList;

public class Solution {
    public ListNode sortInList(ListNode head) {
        ArrayList<ListNode<Integer>> list = new ArrayList<>();
        ListNode<Integer> t = head, c;
        while (t != null) {
            c = t.next;     // 注意脱链
            list.add(t);
            t = c;
        }
        list.sort((x, y) -> x.val - y.val);
        head = new ListNode<>(-1);
        t = head;
        while (!list.isEmpty()) {
            t.next = list.remove(0);
            t = t.next;
        }
        return head.next;
    }
}
