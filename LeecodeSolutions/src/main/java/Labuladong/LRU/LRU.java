package Labuladong.LRU;

import java.util.HashMap;

/**
 * @有bug
 */
class LRUCache {
    private class Node {
        int k, v;
        Node pre, next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private class DoubleList {
        private Node head = new Node(-1, -1);
        private Node last;
        private int size = 0;

        public void addFirst(Node x) {  // 头插：O(1)
            Node t = head.next;
            head.next = x;
            x.pre = head;
            if (last == null || last == head) {
                last = x;
                return;
            }
            t.pre = x;
            x.next = t;
            size++;
        }

        public void remove(Node x) {    // 给的是链表中的节点本身，O(1)
            x.pre.next = x.next;
            if (x.next == null) {
                last = x.pre;
            } else {
                x.next.pre = x.pre;
            }
            x.pre = x.next = null;
            size--;
        }

        public Node removeLast() {
            Node t = last;
            last = last.pre;
            t.pre = t.next = last.next = null;
            size--;
            return t;
        }
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new DoubleList();
        this.map = new HashMap<>();
    }

    public int get(int k) {
        if (!map.containsKey(k)) return -1;
        int val = map.get(k).v;
        put(k, val);
        return val;
    }

    public void put(int k, int v) {
        Node x = new Node(k, v);
        if (map.containsKey(k)) {
            cache.remove(map.get(k));
            cache.addFirst(x);
            map.put(k, x);
        } else {
            if (capacity == cache.size) {
                Node last = cache.removeLast();
                map.remove(last.k);
            }
            cache.addFirst(x);
            map.put(k, x);
        }
    }
}

public class LRU {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.put(1, 3);
        lru.put(2, 5);
        System.out.println(lru.get(1));
        lru.put(4, 4);
    }
}
