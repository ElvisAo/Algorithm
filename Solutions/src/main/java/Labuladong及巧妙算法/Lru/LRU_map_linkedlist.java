package Labuladong及巧妙算法.Lru;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU_map_linkedlist {
    private HashMap<Integer, Integer> map;
    private final int capacity;   // capacity是容量上限
    private LinkedList<Integer> cache;

    public LRU_map_linkedlist(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new LinkedList<>();
    }

    public int get(int k) {
        if (!map.containsKey(k)) return -1;
        cache.remove(new Integer(k));
        cache.addFirst(k);
        return map.get(k);
    }

    public void put(int k, int v) {
        if (map.containsKey(k)) {
            // 包含
            cache.remove(new Integer(k));
            cache.addFirst(k);
            map.put(k, v);
        } else {
            // 不包含
            if (capacity == cache.size()) {
                Integer last = cache.removeLast();
                map.remove(last);
            }
            cache.addFirst(k);
            map.put(k, v);
        }
    }
}
