package nowcoder.堆.字符串出现次数的TopK问题;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Solution {
    public static void main(String[] args) {
        String[] strs = new String[]{"1", "9"};
        System.out.println(new Solution().topKstrings(strs, 1)[0][0]);
    }

    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k       int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings(String[] strings, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> {
            if (x.times.equals(y.times)) return x.value.compareTo(y.value);
            return y.times - x.times;
        });
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++)
            map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Pair cur = new Pair(entry.getKey(), entry.getValue());
            pq.add(cur);
        }
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            Pair poll = pq.poll();
            res[i][0] = poll.value;
            res[i][1] = poll.times.toString();
        }
        return res;
    }
}

class Pair {
    String value;
    Integer times;

    public Pair(String value, int times) {
        this.value = value;
        this.times = times;
    }
}