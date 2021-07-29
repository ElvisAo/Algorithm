package nowcoder.模拟.设计LRU缓存结构;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] LRU(int[][] operators, int k) {
        int ln = operators.length;
        LRU lru = new LRU(k);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < ln; i++) {
            int op = operators[i][0];
            if (op == 1) {
                lru.put(operators[i][1], operators[i][2]);
            } else if (op == 2) {
                list.add(lru.get(operators[i][1]));
            }
        }
        int[] r = new int[list.size()];
        int ri = 0;
        while (!list.isEmpty()) {
            r[ri++] = list.poll();
        }
        return r;
    }
    class LRU {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int capacity;

        public LRU(int capacity) {
            this.capacity = capacity;
        }

        public void put(int key, int val) {
            if (map.size() < capacity) {
                if (map.containsKey(key)) {
                    map.remove(key);
                }
                map.put(key, val);
            } else {
                if (map.containsKey(key)) {
                    map.remove(key);
                    map.put(key, val);
                } else {
                    Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                    iterator.next();
                    iterator.remove();
                    map.put(key, val);
                }
            }
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Integer val = map.remove(key);
                map.put(key, val);
                return val;
            }
            return -1;
        }
    }

}
