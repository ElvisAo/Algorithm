import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode head = new ListNode(-1), min = null, t = head;
        int minIdx = 0;
        while (!lists.isEmpty()) {
            if (lists.size() == 1) {
                t.next = lists.get(0);
                break;
            }
            for (int i = 0; i < lists.size(); i++) {
                if (i == 0 || min.val > lists.get(i).val) {
                    min = lists.get(i);
                    minIdx = i;
                }
            }
            t.next = min;
            t = min;
            lists.remove(minIdx);
            if (min.next != null) lists.add(min.next);
        }
        return head.next;
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println(new Integer(12345)==new Integer(12345));
    }
}

