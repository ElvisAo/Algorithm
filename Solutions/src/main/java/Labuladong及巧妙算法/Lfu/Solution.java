package Labuladong及巧妙算法.Lfu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

/**
 * leetcode 460
 * 用节点封装数据，hashmap存储数据，freqmap封装访问频率（被访问后放的链表开始位置）
 */
public class Solution {
    public static void main(String[] args) {
        // expected output: 1,-1,3,-1,3,4
        LFUCache lfu = new Solution().new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(1));
        lfu.put(3, 3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4, 4);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
    }

    class LFUCache {
        int minFreq, capacity;
        HashMap<Integer, LinkedList<FreqNode>> freqMap;
        HashMap<Integer, FreqNode> map;

        // 只根据key判断是否equals
        class FreqNode {
            int k, v, freq;

            public FreqNode(int k, int v, int freq) {
                this.k = k;
                this.v = v;
                this.freq = freq;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                FreqNode freqNode = (FreqNode) o;
                return k == freqNode.k;
            }

            @Override
            public int hashCode() {
                return Objects.hash(k);
            }
        }

        public LFUCache(int capacity) {
            this.capacity = capacity;
            freqMap = new HashMap<>();
            map = new HashMap<>();
            minFreq = 0;
        }

        /**
         * 晋升节点
         * 1. 在freqmap中把node晋级
         *
         * @param node
         */
        private void promotion(FreqNode node) {
            int old_freq = node.freq;   // node的 旧freq
            node.freq++;    // freq++
            freqMap.get(old_freq).remove(node); // 先在旧的freqmap中删除该点
            // 如果旧的freq对应的链表已空并且旧的freq是minFreq, minFreq+1;
            if (freqMap.get(old_freq).isEmpty() && old_freq == minFreq) minFreq++;
            // 如果新的频率为空
            if (freqMap.get(node.freq) == null) freqMap.put(node.freq, new LinkedList<>());
            freqMap.get(node.freq).addFirst(node);
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            int v = map.get(key).v;
            promotion(map.get(key));
            return v;
        }

        /**
         * 1. 如果包含该key，则为修改，然后晋升该节点
         * 2. 如果不包含，则看容量是否已满
         * 2.1. 如果已满，先删除最小频率的最后元素
         * 2.2. 然后不管已满未满，添加一个频率为1的节点
         *
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            if (capacity == 0) return;
            if (!map.containsKey(key)) {
                // 不包含
                if (map.size() == capacity) {   // 删除最小访问频率的
                    LinkedList<FreqNode> minFreqList = freqMap.get(minFreq);
                    FreqNode last = minFreqList.removeLast();
                    map.remove(last.k);
                }
                FreqNode node = new FreqNode(key, value, 1);
                minFreq = 1;
                if (!freqMap.containsKey(minFreq)) freqMap.put(minFreq, new LinkedList<>());
                freqMap.get(minFreq).addFirst(node);
                map.put(key, node);
            } else {
                // 包含
                FreqNode freqNode = map.get(key);
                freqNode.v = value;
                promotion(freqNode);
            }
        }
    }
}
