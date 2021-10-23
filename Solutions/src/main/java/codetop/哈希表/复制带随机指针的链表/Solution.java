package codetop.哈希表.复制带随机指针的链表;

import java.util.HashMap;

/**
 * leetcode 138
 */
public class Solution {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        HashMap<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
        }
        return map.get(head);
    }
}
