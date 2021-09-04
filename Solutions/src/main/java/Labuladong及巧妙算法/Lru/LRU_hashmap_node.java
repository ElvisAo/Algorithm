package Labuladong及巧妙算法.Lru;

import java.util.HashMap;

/**
 * leetcode 146x
 */
class LRUCache {
    private HashMap<Integer, Integer> map;
    private final int capacity;   // capacity是容量上限
    private DoubleList<Integer> cache;

    class Node {
        Node pre, next;
        Integer val;

        public Node(Integer val) {
            this.val = val;
        }
    }

    class DoubleList<T> {
        private Node head;
        private Node last;
        private int size;

        public DoubleList() {
            head = new Node(null);
            last = head;
            size = 0;
        }

        public Node removeLast() {
            if (size == 0) return null;
            Node t = last;
            last = last.pre;
            last.next = t.pre = null;
            size--;
            return t;
        }

        public void addFirst(Node node) {
            node.pre = head;
            if (size == 0) {  // head == last
                head.next = node;
                last = node;
            } else {
                node.next = head.next;
                node.next.pre = node;
                head.next = node;
            }
            size++;
        }

        public void remove(Node node) {
            Node t = head.next;
            while (t != null && !t.val.equals(node.val)) {
                t = t.next;
            }
            if (t == null) return;
            if (t == last) {
                last = last.pre;
                last.next.pre = null;
                last.next = null;
            } else {
                t.pre.next = t.next;
                t.next.pre = t.pre;
                t.pre = t.next = null;
            }
            size--;
        }

        public int size() {
            return size;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList<>();
    }

    public int get(int k) {
        if (!map.containsKey(k)) return -1;
        cache.remove(new Node(k));
        cache.addFirst(new Node(k));
        return map.get(k);
    }

    public void put(int k, int v) {
        if (map.containsKey(k)) {
            // 包含
            cache.remove(new Node(k));
            cache.addFirst(new Node(k));
            map.put(k, v);
        } else {
            // 不包含
            if (capacity == cache.size()) {
                Integer last = cache.removeLast().val;
                map.remove(last);   // 这里必须删除，因为get的时候是直接从map中get
            }
            cache.addFirst(new Node(k));
            map.put(k, v);
        }
    }
}

public class LRU_hashmap_node {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2); // 标准
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}
