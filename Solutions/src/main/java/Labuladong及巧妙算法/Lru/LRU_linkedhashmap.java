package Labuladong及巧妙算法.Lru;

import java.util.LinkedHashMap;

public class LRU_linkedhashmap {
    private LinkedHashMap<Integer, Integer> map;
    private int capacity;

    public LRU_linkedhashmap(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity,0.75f, true);
    }

    public int get(int k) {
        return map.getOrDefault(k, -1);
    }

    public void put(int k, int v) {
        // 包含
        if (map.containsKey(k)) {
            map.remove(k);
        }
        // 不包含但是容量已满
        else if (map.size() == this.capacity) {
            Integer f = map.keySet().iterator().next();
            map.remove(f);
        }
        map.put(k, v);
    }
}
