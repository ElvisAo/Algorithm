package 真题.面试真题.华为.双向链表;

public class Solution {
    class DNode {
        int val;
        DNode pre, next;

        public DNode(int val) {
            this.val = val;
        }
    }

    class DLinkedList {
        DNode head, tail;
        int size;

        public void addLast(int val) {
            DNode node = new DNode(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }

        public void addFirst(int val) {
            DNode node = new DNode(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                head.pre = node;
                node.next = head;
                head = node;
            }
        }

        public void delete(int val) {
            DNode t;
            if (head == null) return;
            else if (head == tail && head.val == val) {
                head = null;
                tail = null;
            } else {
                if (head.val == val) {
                    t = head.next;
                    head.next = null;
                    t.pre = null;
                    head = t;
                } else if (tail.val == val) {
                    t = tail.pre;
                    tail.pre = null;
                    t.next = null;
                    tail = t;
                } else {
                    t = head;
                    while (t != null && t.val != val) t = t.next;
                    if (t == null) return;
                    t.next.pre = t.pre;
                    t.pre.next = t.next;
                    t.pre = t.next = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(null == null);
    }
}